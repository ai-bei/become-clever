package com.bytespaces.DesignPatterns.Strategy;

import com.bytespaces.DesignPatterns.Strategy.Behavior.Impl.CommonBehavior;

/**
 * Copyright (C), 2010-2023
 * FileName:     RedheadDuck
 * Author:       shine
 * Date:         2023/4/27 14:15
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class RedheadDuck extends Duck {

    public RedheadDuck() {
        // 红头鸭不能飞，所以我们修改默认的飞行行为
        flyBehavior = new CommonBehavior();
    }

    @Override
    public void display() {
        System.out.println("我是一只红头鸭");
    }
}
