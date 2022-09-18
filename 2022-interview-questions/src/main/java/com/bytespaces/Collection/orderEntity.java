package com.bytespaces.Collection;

import com.bytespaces.ReflectionDemo.Student;

/**
 * Copyright (C), 2010-2022,
 * FileName:     orderEntity
 * Author:       shine
 * Date:         2022/9/12 17:54
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class orderEntity {


    public orderEntity(String id, String name,Integer num) {
        this.name = name;
        this.id = id;
        this.num = num;
    }

    private String name;

    private String id;

    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        System.out.println("obj hashCode == ");
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("obj equals == ");
        if (this == obj) {
            return true;    //对象引用相等则一定相同
        }
        if (!(obj instanceof orderEntity)) {
            return false;    //判断类型是否相等（包含了不为空的判断）
        }
        orderEntity entity = (orderEntity) obj;
        return this.id.equals(entity.id) ;
    }
}
