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

package org.apache.shardingsphere.sharding.merge.dql;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.sharding.merge.dql.groupby.GroupByMemoryMergedResult;
import org.apache.shardingsphere.sharding.merge.dql.groupby.GroupByStreamMergedResult;
import org.apache.shardingsphere.sharding.merge.dql.iterator.IteratorStreamMergedResult;
import org.apache.shardingsphere.sharding.merge.dql.orderby.OrderByStreamMergedResult;
import org.apache.shardingsphere.sharding.merge.dql.pagination.LimitDecoratorMergedResult;
import org.apache.shardingsphere.spi.database.type.DatabaseType;
import org.apache.shardingsphere.sql.parser.binder.metadata.schema.SchemaMetaData;
import org.apache.shardingsphere.sql.parser.binder.segment.select.orderby.OrderByItem;
import org.apache.shardingsphere.sql.parser.binder.segment.select.pagination.PaginationContext;
import org.apache.shardingsphere.sql.parser.binder.statement.SQLStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.dml.SelectStatementContext;
import org.apache.shardingsphere.sql.parser.sql.constant.OrderDirection;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.order.item.IndexOrderByItemSegment;
import org.apache.shardingsphere.sql.parser.sql.util.SQLUtil;
import org.apache.shardingsphere.underlying.executor.QueryResult;
import org.apache.shardingsphere.underlying.merge.engine.merger.ResultMerger;
import org.apache.shardingsphere.underlying.merge.result.MergedResult;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 重写第三方依赖包的代码，以兼容分表的分页查询<br>
 * DQL result merger for Sharding.
 */
@RequiredArgsConstructor
public final class ShardingDQLResultMerger implements ResultMerger {

	@SuppressWarnings("unused")
	private final DatabaseType databaseType; // 不能删

	@SuppressWarnings("rawtypes")
	@Override
	public MergedResult merge(final List<QueryResult> queryResults, final SQLStatementContext sqlStatementContext,
			final SchemaMetaData schemaMetaData) throws SQLException {
		if (1 == queryResults.size()) {
			return new IteratorStreamMergedResult(queryResults);
		}
		Map<String, Integer> columnLabelIndexMap = getColumnLabelIndexMap(queryResults.get(0));
		SelectStatementContext selectStatementContext = (SelectStatementContext) sqlStatementContext;
		selectStatementContext.setIndexes(columnLabelIndexMap);
		MergedResult mergedResult = build(queryResults, selectStatementContext, columnLabelIndexMap, schemaMetaData);
		return decorate(queryResults, selectStatementContext, mergedResult);
	}

	private Map<String, Integer> getColumnLabelIndexMap(final QueryResult queryResult) throws SQLException {
		Map<String, Integer> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (int i = queryResult.getColumnCount(); i > 0; i--) {
			result.put(SQLUtil.getExactlyValue(queryResult.getColumnLabel(i)), i);
		}
		return result;
	}

	private MergedResult build(final List<QueryResult> queryResults,
			final SelectStatementContext selectStatementContext, final Map<String, Integer> columnLabelIndexMap,
			final SchemaMetaData schemaMetaData) throws SQLException {
		if (isNeedProcessGroupBy(selectStatementContext)) {
			return getGroupByMergedResult(queryResults, selectStatementContext, columnLabelIndexMap, schemaMetaData);
		}
		if (isNeedProcessDistinctRow(selectStatementContext)) {
			setGroupByForDistinctRow(selectStatementContext);
			return getGroupByMergedResult(queryResults, selectStatementContext, columnLabelIndexMap, schemaMetaData);
		}
		if (isNeedProcessOrderBy(selectStatementContext)) {
			return new OrderByStreamMergedResult(queryResults, selectStatementContext, schemaMetaData);
		}
		return new IteratorStreamMergedResult(queryResults);
	}

	private boolean isNeedProcessGroupBy(final SelectStatementContext selectStatementContext) {
		return !selectStatementContext.getGroupByContext().getItems().isEmpty()
				|| !selectStatementContext.getProjectionsContext().getAggregationProjections().isEmpty();
	}

	private boolean isNeedProcessDistinctRow(final SelectStatementContext selectStatementContext) {
		return selectStatementContext.getProjectionsContext().isDistinctRow();
	}

	private void setGroupByForDistinctRow(final SelectStatementContext selectStatementContext) {
		for (int index = 1; index <= selectStatementContext.getProjectionsContext().getExpandProjections()
				.size(); index++) {
			OrderByItem orderByItem = new OrderByItem(
					new IndexOrderByItemSegment(-1, -1, index, OrderDirection.ASC, OrderDirection.ASC));
			orderByItem.setIndex(index);
			selectStatementContext.getGroupByContext().getItems().add(orderByItem);
		}
	}

	private MergedResult getGroupByMergedResult(final List<QueryResult> queryResults,
			final SelectStatementContext selectStatementContext, final Map<String, Integer> columnLabelIndexMap,
			final SchemaMetaData schemaMetaData) throws SQLException {
		return selectStatementContext.isSameGroupByAndOrderByItems()
				? new GroupByStreamMergedResult(columnLabelIndexMap, queryResults, selectStatementContext,
						schemaMetaData)
				: new GroupByMemoryMergedResult(queryResults, selectStatementContext, schemaMetaData);
	}

	private boolean isNeedProcessOrderBy(final SelectStatementContext selectStatementContext) {
		return !selectStatementContext.getOrderByContext().getItems().isEmpty();
	}

	private MergedResult decorate(final List<QueryResult> queryResults,
			final SelectStatementContext selectStatementContext, final MergedResult mergedResult) throws SQLException {
		PaginationContext paginationContext = selectStatementContext.getPaginationContext();
		if (!paginationContext.isHasPagination() || 1 == queryResults.size()) {
			return mergedResult;
		}
//        String trunkDatabaseName = DatabaseTypes.getTrunkDatabaseType(databaseType.getName()).getName();
//        if ("MySQL".equals(trunkDatabaseName) || "PostgreSQL".equals(trunkDatabaseName)) {
		return new LimitDecoratorMergedResult(mergedResult, paginationContext);
//        }
//        if ("Oracle".equals(trunkDatabaseName)) {
//            return new RowNumberDecoratorMergedResult(mergedResult, paginationContext);
//        }
//        if ("SQLServer".equals(trunkDatabaseName)) {
//            return new TopAndRowNumberDecoratorMergedResult(mergedResult, paginationContext);
//        }
//        return mergedResult;
	}
}
