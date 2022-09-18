package com.bytespaces.Collection;

import cn.hutool.core.collection.CollectionUtil;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Copyright (C), 2010-2022,
 * FileName:     collectionUtilsDemo
 * Author:       shine
 * Date:         2022/9/12 17:53
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class collectionUtilsDemo {
    public static void main(String[] args) {

        List<orderEntity> listArryA = new ArrayList<>();
        List<orderEntity> listArryB = new ArrayList<>();

        // 生成10000条数据
        for (int i = 0; i < 10; i++) {
            orderEntity order = new orderEntity(String.valueOf(i),UUID.randomUUID().toString(),i);
            listArryA.add(order);
        }

        // 生成10000条数据
        for (int i = 5; i < 20; i++) {
            orderEntity order = new orderEntity(String.valueOf(i),UUID.randomUUID().toString(),i);
            listArryB.add(order);
        }


        // 求两个集合的并集
        Collection<orderEntity> union = CollectionUtil.union(listArryA, listArryB);

        // 求两个集合的交集
        Collection<orderEntity> intersection = CollectionUtil.intersection(listArryA, listArryB);


        System.out.println();

    }
}
