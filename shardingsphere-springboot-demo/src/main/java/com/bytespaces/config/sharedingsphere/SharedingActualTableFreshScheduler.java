package com.bytespaces.config.sharedingsphere;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.core.rule.ShardingRule;
import org.apache.shardingsphere.core.rule.TableRule;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.apache.shardingsphere.underlying.common.rule.DataNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Copyright (C), 2010-2022,
 * FileName:     SharedingActualTableFreshScheduler
 * Author:       zhangxiaoyu
 * Date:         2022/04/25 14:47
 * Description:  每日刷新shareding配置的物理表
 * History:
 * <author>      <time>          <version>          <desc> <br>
 * 作者姓名       修改时间         版本号             描述 <br>
 */
@Slf4j
@Configuration
@AutoConfigureAfter({SpringBootConfiguration.class})
@ConditionalOnProperty(name = "sharding-sphere-fresh")
@Component
public class SharedingActualTableFreshScheduler implements ApplicationRunner {

    @Resource
    private ShardingDataSource shardingDataSource;

    /**
     * properties中读取刷新的表，格式为JSONObject，获取用Map
     */
    @Value("#{${sharding-sphere-fresh}}")
    private Map<String, String> tables;



    @Scheduled(cron = "${freshTableCron}")
    public void FreshTable() {
        log.info("开始刷新jdbc分表的配置");
        if (tables!=null){
            for (String logicTable : tables.keySet()) {
                FreshTable(logicTable, tables.get(logicTable));
            }
        }
    }


    public void FreshTable(String logicTable, String templeteTable){
        Map<String, DataSource> dataSourceMap = shardingDataSource.getDataSourceMap();

        ShardingRule shardingRule = shardingDataSource.getRuntimeContext().getRule();
//        获得逻辑表名的规则
        Optional<TableRule> tableRuleOpt = shardingRule.findTableRule(logicTable);
        if (!tableRuleOpt.isPresent()){
            log.info("{}未在sharding注册表关系",logicTable);
            return;
        }
        TableRule tableRule = tableRuleOpt.get();
        List<DataNode> actualDataNodes = tableRule.getActualDataNodes();
//        逻辑库名，若无则默认返回第一个
        String dataSourceName = actualDataNodes.stream()
                .filter(dataNode -> logicTable.equals(dataNode.getTableName()))
                .findFirst().orElse(actualDataNodes.get(0)).getDataSourceName();
        List<String> actualTables = getActualDataNodes(dataSourceName, dataSourceMap.get(dataSourceName), templeteTable);

        modifyShardingTables(actualTables, tableRule, dataSourceName);
        modifyShardingDataNode(actualTables,tableRule, actualDataNodes, dataSourceName);
    }

    private void modifyShardingDataNode(List<String> actualTables, TableRule tableRule, List<DataNode> actualDataNodes, String dataSourceName) {
        for (String actualTable : actualTables) {
            String fullTableName = dataSourceName+"."+actualTable;
            DataNode newDataNode = new DataNode(fullTableName);
            if (!actualDataNodes.contains(newDataNode)) {
                actualDataNodes.add(newDataNode);
            }
        }
        try {
            Field dataNodeIndexMapField = TableRule.class.getDeclaredField("dataNodeIndexMap");
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(dataNodeIndexMapField, dataNodeIndexMapField.getModifiers() & ~Modifier.FINAL);
            dataNodeIndexMapField.setAccessible(true);
            int index = 0;
            Map<DataNode, Integer> dataNodeIndexMap = new HashMap<>();
            for (Iterator<DataNode> it = actualDataNodes.iterator(); it.hasNext(); ++index) {
                DataNode dataNode = it.next();
                dataNodeIndexMap.put(dataNode, index);
            }
            dataNodeIndexMapField.set(tableRule, dataNodeIndexMap);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    /**
     * 修改Sharding中的分区达到动态分区的效果
     * @param actualTables
     */
    private void modifyShardingTables(List<String> actualTables, TableRule tableRule, String dataSourceName) {
        Map<String, Collection<String>> datasourceToTablesMap = tableRule.getDatasourceToTablesMap();
        Collection<String> actualDatasourceNames = tableRule.getActualDatasourceNames();
        Collection<String> tableList = datasourceToTablesMap.get(dataSourceName);

        for (String tableName : actualTables) {
            if (tableList.contains(tableName)){
                continue;
            }else {
                tableList.add(tableName);
            }
            datasourceToTablesMap.put(dataSourceName, tableList);
            if (!actualDatasourceNames.contains(tableName)){
                actualDatasourceNames.add(dataSourceName);
            }
        }
    }


    /**
     *
     *
     *
     * @param dataSourceName
     * @param dataSource
     * @param templeteTable 表前缀
     *                   查询数据库，获得物理表
     * @return
     */
    @SneakyThrows
    private List<String> getActualDataNodes(String dataSourceName, DataSource dataSource, String templeteTable) {
        List<String> dataNodes= new ArrayList<>();
        Connection connection = null;
        Statement stmt =null;
        ResultSet resultSet =null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
//            resultSet = stmt.executeQuery("SELECT table_name from information_schema.tables WHERE TABLE_SCHEMA = 'irms_standard' and  table_name like '"+templeteTable+"_%' ORDER BY table_name");
//            添加指定库名、实例名前缀
            String sql = "";
            if (templeteTable.contains(":")){
                String tablenname = templeteTable.substring(templeteTable.indexOf(":")+1);
                String schama =templeteTable.substring(0,templeteTable.indexOf(":")+1);
                sql = "select concat('"+schama+"', tabname) from "+schama+"systables where tabname like '" + tablenname +"_%' order by tabname ";
            }else {
//                sql = "select tabname from systables where tabname like '" + templeteTable +"_%' order by tabname ";
                sql = "select table_name from information_schema.tables where table_name like '" + templeteTable +"_%' order by table_name ";
            }

            log.info("使用{}查询到{}的物理表：{}", dataSourceName, templeteTable, sql);

            resultSet = stmt.executeQuery(sql);
            int i= 1;
            Pattern compile = Pattern.compile(templeteTable + "_\\d+$");
            while (resultSet.next()){
                String actualTable = resultSet.getString(1);
                if (compile.matcher(actualTable).find()){
                    log.info(i++ +":"+actualTable);
                    dataNodes.add(actualTable);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
        return dataNodes;
    }


    /**
     * 启动时执行一次
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FreshTable();
    }
}