package com.bytespaces.classLoad;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz=new MyClassLoader().loadClass("com.bytespaces.classLoad.ClassTest");
        //这就是我们接口的作用。如果没有接口，就需要利用反射来实现了。
        InterfaceTest classTest=(InterfaceTest) clazz.newInstance();
        classTest.name();
        classTest.age();
    }
}
