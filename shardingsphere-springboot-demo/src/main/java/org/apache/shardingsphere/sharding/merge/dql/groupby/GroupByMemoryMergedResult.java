/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sharding.merge.dql.groupby;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shardingsphere.core.rule.ShardingRule;
import org.apache.shardingsphere.sharding.merge.dql.groupby.aggregation.AggregationUnit;
import org.apache.shardingsphere.sharding.merge.dql.groupby.aggregation.AggregationUnitFactory;
import org.apache.shardingsphere.sql.parser.binder.metadata.column.ColumnMetaData;
import org.apache.shardingsphere.sql.parser.binder.metadata.schema.SchemaMetaData;
import org.apache.shardingsphere.sql.parser.binder.metadata.table.TableMetaData;
import org.apache.shardingsphere.sql.parser.binder.segment.select.projection.impl.AggregationDistinctProjection;
import org.apache.shardingsphere.sql.parser.binder.segment.select.projection.impl.AggregationProjection;
import org.apache.shardingsphere.sql.parser.binder.statement.SQLStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.dml.SelectStatementContext;
import org.apache.shardingsphere.sql.parser.sql.segment.generic.table.SimpleTableSegment;
import org.apache.shardingsphere.underlying.executor.QueryResult;
import org.apache.shardingsphere.underlying.merge.result.impl.memory.MemoryMergedResult;
import org.apache.shardingsphere.underlying.merge.result.impl.memory.MemoryQueryResultRow;

import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;

/**
 * Memory merged result for group by.
 */
public final class GroupByMemoryMergedResult extends MemoryMergedResult<ShardingRule> {

    public GroupByMemoryMergedResult(final List<QueryResult> queryResults, final SelectStatementContext selectStatementContext, final SchemaMetaData schemaMetaData) throws SQLException {
        super(null, schemaMetaData, selectStatementContext, queryResults);
    }

    @Override
    protected List<MemoryQueryResultRow> init(final ShardingRule shardingRule,
                                              final SchemaMetaData schemaMetaData, final SQLStatementContext sqlStatementContext, final List<QueryResult> queryResults) throws SQLException {
        SelectStatementContext selectStatementContext = (SelectStatementContext) sqlStatementContext;
        Map<GroupByValue, MemoryQueryResultRow> dataMap = new HashMap<>(1024);
        Map<GroupByValue, Map<AggregationProjection, AggregationUnit>> aggregationMap = new HashMap<>(1024);
        for (QueryResult each : queryResults) {
            while (each.next()) {
                GroupByValue groupByValue = new GroupByValue(each, selectStatementContext.getGroupByContext().getItems());
                initForFirstGroupByValue(selectStatementContext, each, groupByValue, dataMap, aggregationMap);
                aggregate(selectStatementContext, each, groupByValue, aggregationMap);
            }
        }
        setAggregationValueToMemoryRow(selectStatementContext, dataMap, aggregationMap);
        List<Boolean> valueCaseSensitive = queryResults.isEmpty() ? Collections.emptyList() : getValueCaseSensitive(queryResults.iterator().next(), selectStatementContext, schemaMetaData);
        return getMemoryResultSetRows(selectStatementContext, dataMap, valueCaseSensitive);
    }

    private void initForFirstGroupByValue(final SelectStatementContext selectStatementContext, final QueryResult queryResult,
                                          final GroupByValue groupByValue, final Map<GroupByValue, MemoryQueryResultRow> dataMap,
                                          final Map<GroupByValue, Map<AggregationProjection, AggregationUnit>> aggregationMap) throws SQLException {
        if (!dataMap.containsKey(groupByValue)) {
            dataMap.put(groupByValue, new MemoryQueryResultRow(queryResult));
        }
        if (!aggregationMap.containsKey(groupByValue)) {
            Map<AggregationProjection, AggregationUnit> map = Maps.toMap(selectStatementContext.getProjectionsContext().getAggregationProjections(),
                    input -> AggregationUnitFactory.create(input.getType(), input instanceof AggregationDistinctProjection));
            aggregationMap.put(groupByValue, map);
        }
    }

    private void aggregate(final SelectStatementContext selectStatementContext, final QueryResult queryResult,
                           final GroupByValue groupByValue, final Map<GroupByValue, Map<AggregationProjection, AggregationUnit>> aggregationMap) throws SQLException {
        for (AggregationProjection each : selectStatementContext.getProjectionsContext().getAggregationProjections()) {
            List<Comparable<?>> values = new ArrayList<>(2);
            if (each.getDerivedAggregationProjections().isEmpty()) {
                values.add(getAggregationValue(queryResult, each));
            } else {
                for (AggregationProjection derived : each.getDerivedAggregationProjections()) {
                    values.add(getAggregationValue(queryResult, derived));
                }
            }
            aggregationMap.get(groupByValue).get(each).merge(values);
        }
    }

    private Comparable<?> getAggregationValue(final QueryResult queryResult, final AggregationProjection aggregationProjection) throws SQLException {
        Object result = queryResult.getValue(aggregationProjection.getIndex(), Object.class);
        Preconditions.checkState(null == result || result instanceof Comparable, "Aggregation value must implements Comparable");
        return (Comparable<?>) result;
    }

    private void setAggregationValueToMemoryRow(final SelectStatementContext selectStatementContext,
                                                final Map<GroupByValue, MemoryQueryResultRow> dataMap, final Map<GroupByValue, Map<AggregationProjection, AggregationUnit>> aggregationMap) {
        for (Entry<GroupByValue, MemoryQueryResultRow> entry : dataMap.entrySet()) {
            for (AggregationProjection each : selectStatementContext.getProjectionsContext().getAggregationProjections()) {
                entry.getValue().setCell(each.getIndex(), aggregationMap.get(entry.getKey()).get(each).getResult());
            }
        }
    }

    private List<Boolean> getValueCaseSensitive(final QueryResult queryResult, final SelectStatementContext selectStatementContext, final SchemaMetaData schemaMetaData) throws SQLException {
        List<Boolean> result = Lists.newArrayList(false);
        for (int columnIndex = 1; columnIndex <= queryResult.getColumnCount(); columnIndex++) {
            result.add(getValueCaseSensitiveFromTables(queryResult, selectStatementContext, schemaMetaData, columnIndex));
        }
        return result;
    }

    private boolean getValueCaseSensitiveFromTables(final QueryResult queryResult, final SelectStatementContext selectStatementContext,
                                                    final SchemaMetaData schemaMetaData, final int columnIndex) throws SQLException {

        try {
            for (SimpleTableSegment each : selectStatementContext.getAllTables()) {
                String tableName = each.getTableName().getIdentifier().getValue();
                TableMetaData tableMetaData = schemaMetaData.get(tableName);
                Map<String, ColumnMetaData> columns = tableMetaData.getColumns();
                String columnName = queryResult.getColumnName(columnIndex);
                if (columns.containsKey(columnName)) {
                    return columns.get(columnName).isCaseSensitive();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("字段未注册：" + queryResult.getColumnName(columnIndex));
        }
        return false;
    }

    private List<MemoryQueryResultRow> getMemoryResultSetRows(final SelectStatementContext selectStatementContext,
                                                              final Map<GroupByValue, MemoryQueryResultRow> dataMap, final List<Boolean> valueCaseSensitive) {
        List<MemoryQueryResultRow> result = new ArrayList<>(dataMap.values());
        result.sort(new GroupByRowComparator(selectStatementContext, valueCaseSensitive));
        return result;
    }
}
