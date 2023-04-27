package com.bytespaces.DesignPatterns.Strategy;

import com.bytespaces.DesignPatterns.Strategy.Behavior.Behavior;
import com.bytespaces.DesignPatterns.Strategy.Behavior.Impl.CommonBehavior;
import com.bytespaces.DesignPatterns.Strategy.Behavior.Impl.FlyBehavior;
import com.bytespaces.DesignPatterns.Strategy.Behavior.Impl.QuackBehavior;

/**
 * Copyright (C), 2010-2023
 * FileName:     Duck
 * Author:       shine
 * Date:         2023/4/27 14:10
 * Description: 我们定义一个抽象类Duck，其中定义了三个行为，
 *              分别是CommonBehavior、FlyBehavior和QuackBehavior，具体实现可以子类继承，
 *              还有一个perform方法，默认输出一些鸭子的信息。
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public abstract  class Duck {
    protected Behavior commonBehavior;
    protected Behavior flyBehavior;
    protected Behavior quackBehavior;

    public Duck() {
        commonBehavior = new CommonBehavior();
        flyBehavior = new FlyBehavior();
        quackBehavior = new QuackBehavior();
    }

    public abstract void display();

    public void perform() {
        System.out.println("我是一只鸭子，我有以下几个行为：");
        commonBehavior.doBehavior();
        flyBehavior.doBehavior();
        quackBehavior.doBehavior();
    }

    public void setCommonBehavior(Behavior commonBehavior) {
        this.commonBehavior = commonBehavior;
    }

    public void setFlyBehavior(Behavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(Behavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
