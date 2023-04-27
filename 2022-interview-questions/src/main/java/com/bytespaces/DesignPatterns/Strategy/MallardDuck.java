package com.bytespaces.DesignPatterns.Strategy;

/**
 * Copyright (C), 2010-2023
 * FileName:     MallardDuck
 * Author:       shine
 * Date:         2023/4/27 14:14
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class MallardDuck extends Duck {
    public MallardDuck() {}

    @Override
    public void display() {
        System.out.println("我是一只绿头鸭");
    }
}