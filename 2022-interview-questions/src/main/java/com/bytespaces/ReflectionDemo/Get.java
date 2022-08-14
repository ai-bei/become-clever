package com.bytespaces.ReflectionDemo;


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Get {
    //获取反射机制三种方式
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一(通过建立对象)
        Student stu = new Student();
        Class classobj1 = stu.getClass();
        System.out.println(classobj1.getName());

        //方式二（所在通过路径-相对路径）
        Class classobj2 = Class.forName("com.bytespaces.ReflectionDemo.Student");
        System.out.println(classobj2.getName());

        //方式三（通过类名）
        Class classobj3 = Student.class;
        System.out.println(classobj3.getName());
    }


    @Test
    public void demoOne() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //通过反射机制，获取Class，通过Class来实例化对象
        Class<?> cl = Student.class;
        //通过getMethods方法获取所有public修饰的普通方法
        Method[] methods = cl.getMethods();
        for (Method i : methods) {
            System.out.println(i.getName());
        }
        System.out.println("----------------");
        //通过getDeclaredMethods返回类中所有的实例方法
        Method[] methods1 = cl.getDeclaredMethods();
        for (Method i : methods1) {
            System.out.println(i.getName());
        }


        System.out.println("----------------");
        //通过类名.class获取class对象
        Class<?> clazz= Student.class;
        //实例划对象
        Object instance = clazz.newInstance();
        //通过getMethon方法取得setName这个方法的实例化对象，方法名称与参数类型
        Method setMethod = clazz.getMethod("outStr", String.class);
        //通过invoke调用方法
        setMethod.invoke( instance ,"liurh");
        //通过invoke调用方法,带有返回值
        Method  getMethod = clazz.getMethod("returnStr");
        Object result = getMethod.invoke(instance);
        System.out.println(result);
    }
}
