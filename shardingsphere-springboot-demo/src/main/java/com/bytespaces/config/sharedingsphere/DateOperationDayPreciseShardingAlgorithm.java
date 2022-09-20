package com.bytespaces.config.sharedingsphere;



import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Date;

/**
 * Copyright (C), 2010-2022,
 * FileName:     DateOperationDayPreciseShardingAlgorithm
 * Author:       shine
 * Date:         2022/9/20 23:42
 * Description:  sql语句中=号分片
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 * @author shine
 */
@Slf4j
public class DateOperationDayPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        Date operationDay = preciseShardingValue.getValue();
        log.info("[表名<{}> 列名<{}> 分片值<{}>]", preciseShardingValue.getLogicTableName(), preciseShardingValue.getColumnName(),preciseShardingValue.getValue());

        String first = "";
        String value = DateUtil.format(operationDay, "yyyyMMdd");
        for (String physicsTable : collection) {
//            分表后缀
            String suffix = physicsTable.replaceAll(".*\\D", ""); // 替换直到最后一个非数字为空
            if (StringUtils.isEmpty(first)){
                first = physicsTable;
                continue;
            }
            if (value.equals(suffix)){
                log.info("[匹配到物理表: {}]", physicsTable);
                return physicsTable;
            }
        }
        log.info("[未匹配到物理表，返回默认表{}]", first);
        return first;
    }
}
