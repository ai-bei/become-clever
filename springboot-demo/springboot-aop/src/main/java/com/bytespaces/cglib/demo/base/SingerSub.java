package com.bytespaces.cglib.demo.base;

public class SingerSub extends Singer {
    @Override
    public void dance() {
        System.out.println("经纪人商量合同");
        super.dance();
        System.out.println("收钱");

    }
    @Override
    public void singing() {
        System.out.println("经纪人商量合同");
        super.singing();
        System.out.println("收钱");
    }
}
