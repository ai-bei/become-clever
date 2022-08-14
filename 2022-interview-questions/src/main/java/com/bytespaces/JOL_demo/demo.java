package com.bytespaces.JOL_demo;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String[] args) {
        Object o = new Object();
        type type = new type();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(type).toPrintable());
    }




    private static class type {

        /* Java的八种基本的数据类型*/
        int a;
        long b;
        double c;
        float d;
        char e;
        boolean f;
        byte g;
        short h;

        /*Java常用的数据存储对象*/
        String str = "string";
        Map<String,Object> map = new HashMap<>(8);
        List<String> list = new ArrayList<>();
    }
}
