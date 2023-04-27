package com.bytespaces.DesignPatterns.Strategy.Behavior.Impl;

import com.bytespaces.DesignPatterns.Strategy.Behavior.Behavior;

/**
 * Copyright (C), 2010-2023
 * FileName:     CommonBehavior
 * Author:       shine
 * Date:         2023/4/27 14:08
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class CommonBehavior implements Behavior {

    @Override
    public void doBehavior() {
        System.out.println("普通行为");
    }
}
