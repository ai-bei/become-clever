package com.bytespaces.DesignPatterns.Strategy.Behavior.Impl;

import com.bytespaces.DesignPatterns.Strategy.Behavior.Behavior;

/**
 * Copyright (C), 2010-2023
 * FileName:     FlyBehavior
 * Author:       shine
 * Date:         2023/4/27 14:09
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class FlyBehavior implements Behavior {
    @Override
    public void doBehavior() {
        System.out.println("飞行行为");
    }
}
