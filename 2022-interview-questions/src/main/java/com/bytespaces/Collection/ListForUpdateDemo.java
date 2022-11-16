package com.bytespaces.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Copyright (C), 2010-2022,
 * FileName:     ListForUpdateDemo
 * Author:       shine
 * Date:         2022/11/11 15:52
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class ListForUpdateDemo {

    public static void main(String[] args) {

        String name = "";
        List<orderEntity> entityListTest = new ArrayList<>();
        List<orderEntity> entityData = createEntityData(10);
        List<orderEntity> entityDataTwo = createEntityData(5);
        entityDataTwo.add(new orderEntity("A","AAA1",1));
        entityDataTwo.add(new orderEntity("A","AAA2",1));
        entityDataTwo.add(new orderEntity("A","AAA3",1));

        for (orderEntity entityDatum : entityData) {
            for (orderEntity entity : entityDataTwo) {
                if(entity.getId().equals("A")){
                    name = entityDatum.getName();
                    entityListTest.add(createEntity(name));
                }
            }
        }
        System.out.println(entityListTest.size());
    }



    /**
     * 创建entity构建数据源
     * @return
     */
    private static orderEntity createEntity(String name){
        return new orderEntity(UUID.randomUUID().toString() , name ,1);
    }

    /**
     * 创建entityData
     * @return
     */
    private static List<orderEntity> createEntityData(int totle){
        List<orderEntity> entityList = new ArrayList<>();
        for (int i = 0; i < totle; i++) {
            orderEntity order = new orderEntity(String.valueOf(i), UUID.randomUUID().toString(),i);
            entityList.add(order);
        }
        return entityList;
    }



}
