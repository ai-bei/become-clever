package com.bytespaces.DesignPatterns.Strategy.Behavior.Impl;

import com.bytespaces.DesignPatterns.Strategy.Behavior.Behavior;

/**
 * Copyright (C), 2010-2023
 * FileName:     QuackBehavior
 * Author:       shine
 * Date:         2023/4/27 14:10
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class QuackBehavior implements Behavior {
    @Override
    public void doBehavior() {
        System.out.println("呱呱叫行为");
    }
}
