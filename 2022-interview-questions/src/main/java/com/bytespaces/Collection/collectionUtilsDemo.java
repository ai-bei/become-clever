package com.bytespaces.Collection;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

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
            if( i > 10){
                order.setName("AAAA");
            }
            listArryB.add(order);
        }


        // 求两个集合的并集
        Collection<orderEntity> union = CollectionUtil.union(listArryA, listArryB);

        // 求两个集合的交集
        Collection<orderEntity> intersection = CollectionUtil.intersection(listArryA, listArryB);


        // 集合去重
        List<orderEntity> lt1 = listArryB.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(Comparator.comparing(orderEntity::getName))), ArrayList::new));


        System.out.println();





    }
}
