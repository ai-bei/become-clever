package com.bytespaces.config.sharedingsphere;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2010-2022,
 * FileName:     DateOperationDayRangeShardingAlgorithm
 * Author:
 * Date:
 * Description:  日期格式范围分片
 * History:
 * <author>      <time>          <version>          <desc> <br>
 * 作者姓名       修改时间         版本号             描述 <br>
 */
@Slf4j
public class DateOperationDayRangeShardingAlgorithm implements RangeShardingAlgorithm<Date> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Date> rangeShardingValue) {
        Range<Date> valueRange = rangeShardingValue.getValueRange();
        log.info("[表名<{}> 列名<{}> 分片值<{},{}>]", rangeShardingValue.getLogicTableName(), rangeShardingValue.getColumnName(),
                valueRange.lowerEndpoint(), valueRange.upperEndpoint());

        Date operationDayA = valueRange.lowerEndpoint();
        Date operationDayB = valueRange.upperEndpoint();

//        下限
        int lowerCase = operationDayA == null ? 0 : Integer.parseInt(DateUtil.format(operationDayA,"yyyyMM"));
//        上限
        int upperCase = operationDayB == null ? 99999999 : Integer.parseInt(DateUtil.format(operationDayB,"yyyyMM"));
        List<String> findTable = new ArrayList<>(collection.size());
        String first = "";
        for (String physicsTable : collection) {
//            分表后缀
            String suffix = physicsTable.replaceAll(".*\\D", ""); // 替换直到最后一个非数字为空
            if (first.length() == 0){
                first = physicsTable;
                continue;
            }
            int integer = Integer.parseInt(suffix);
            if (lowerCase <= integer && integer <= upperCase){
                findTable.add(physicsTable);
            }
        }
        if (findTable.size() == 0 ){
            log.info("[未匹配到物理表，返回默认表：{}]", first);
            findTable.add(first);
        } else {
            log.info("[匹配到物理表: {}]", StringUtils.join(findTable, ','));
        }
        return findTable;
    }
}
