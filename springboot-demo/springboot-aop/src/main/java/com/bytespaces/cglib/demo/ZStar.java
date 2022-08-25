package com.bytespaces.cglib.demo;

import com.bytespaces.cglib.demo.base.Singer;

public class ZStar extends Singer {

    @Override
    public void singing() {
        System.out.println("我会唱歌.......");
    }
    @Override
    public void dance() {
        System.out.println("我会跳舞......");
    }
}
