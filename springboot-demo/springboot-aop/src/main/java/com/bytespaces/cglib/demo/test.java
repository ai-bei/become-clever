package com.bytespaces.cglib.demo;

import org.springframework.cglib.proxy.Enhancer;

public class test {
    public static void main(String[] args) {

        Enhancer en = new Enhancer();//用来帮我们生成代理对象

        en.setSuperclass(ZStar.class);//设置要代理的目标类

        en.setCallback(new TargetCglib(new ZStar()));//设置执行规则，相当于proxy的Ruler

        ZStar s = (ZStar) en.create();//创造代理对象
        s.dance();//方法测试

        System.out.println("********************");

        s.singing();
    }
}
