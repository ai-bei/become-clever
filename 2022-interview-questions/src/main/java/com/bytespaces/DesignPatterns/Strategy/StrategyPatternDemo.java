package com.bytespaces.DesignPatterns.Strategy;

/**
 * Copyright (C), 2010-2023
 * FileName:     StrategyPatternDemo
 * Author:       shine
 * Date:         2023/4/27 14:15
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.perform();

        System.out.println();

        Duck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.perform();
    }
}
