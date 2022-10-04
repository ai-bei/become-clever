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

package org.apache.shardingsphere.sharding.route.engine.type.unicast;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.core.rule.ShardingRule;
import org.apache.shardingsphere.core.rule.TableRule;
import org.apache.shardingsphere.sharding.route.engine.type.ShardingRouteEngine;
import org.apache.shardingsphere.underlying.common.rule.DataNode;
import org.apache.shardingsphere.underlying.route.context.RouteMapper;
import org.apache.shardingsphere.underlying.route.context.RouteResult;
import org.apache.shardingsphere.underlying.route.context.RouteUnit;

import java.util.*;

/**
 * Sharding unicast routing engine.
 */
@RequiredArgsConstructor
@Slf4j
public final class ShardingUnicastRoutingEngine implements ShardingRouteEngine {

    private final Collection<String> logicTables;

    @Override
    public RouteResult route(final ShardingRule shardingRule) {
        RouteResult result = new RouteResult();
        String dataSourceName = shardingRule.getShardingDataSourceNames().getRandomDataSourceName();
        RouteMapper dataSourceMapper = new RouteMapper(dataSourceName, dataSourceName);
        if (shardingRule.isAllBroadcastTables(logicTables)) {
            List<RouteMapper> tableMappers = new ArrayList<>(logicTables.size());
            for (String each : logicTables) {
                tableMappers.add(new RouteMapper(each, each));
            }
            result.getRouteUnits().add(new RouteUnit(dataSourceMapper, tableMappers));
        } else if (logicTables.isEmpty()) {
            result.getRouteUnits().add(new RouteUnit(dataSourceMapper, Collections.emptyList()));
        } else if (1 == logicTables.size()) {
            String logicTableName = logicTables.iterator().next();
            if (!shardingRule.findTableRule(logicTableName).isPresent()) {
                result.getRouteUnits().add(new RouteUnit(dataSourceMapper, Collections.emptyList()));
                return result;
            }
            DataNode dataNode = shardingRule.getDataNode(logicTableName);
            result.getRouteUnits().add(new RouteUnit(dataSourceMapper, Collections.singletonList(new RouteMapper(logicTableName, dataNode.getTableName()))));
        } else {
            List<RouteMapper> tableMappers = new ArrayList<>(logicTables.size());
            Set<String> availableDatasourceNames = null;
            boolean first = true;

//            从已配的逻辑表中取个最新的
            Set<String> inRule = null;
            for (String each : logicTables) {
                TableRule tableRule = shardingRule.getTableRule(each);

                DataNode dataNode = tableRule.getActualDataNodes().get(0);
                tableMappers.add(new RouteMapper(each, dataNode.getTableName()));
                Set<String> currentDataSourceNames = new HashSet<>(tableRule.getActualDatasourceNames().size());
                for (DataNode eachDataNode : tableRule.getActualDataNodes()) {
                    currentDataSourceNames.add(eachDataNode.getDataSourceName());
                }
                if (shardingRule.findTableRule(each).isPresent()){
                    inRule = currentDataSourceNames;
                }
                if (first) {
                    availableDatasourceNames = currentDataSourceNames;
                    first = false;
                } else {
//                    返回两个集合的交集
                    availableDatasourceNames = Sets.intersection(availableDatasourceNames, currentDataSourceNames);
                }
            }


//            不论如何最少会返回默认库
//            if (availableDatasourceNames.isEmpty()) {
//                throw new ShardingSphereConfigurationException("Cannot find actual datasource intersection for logic tables: %s", logicTables);
//            }
            if (availableDatasourceNames.isEmpty()){
                if (inRule.isEmpty()){
                    availableDatasourceNames.add(shardingRule.getShardingDataSourceNames().getDefaultDataSourceName());
                }else {
                    availableDatasourceNames = inRule;
                }
                log.info("Cannot find actual datasource intersection for logic tables: {}, try to use: {}",logicTables,availableDatasourceNames);
            }
            dataSourceName = shardingRule.getShardingDataSourceNames().getRandomDataSourceName(availableDatasourceNames);
            result.getRouteUnits().add(new RouteUnit(new RouteMapper(dataSourceName, dataSourceName), tableMappers));
        }
        return result;
    }
}
