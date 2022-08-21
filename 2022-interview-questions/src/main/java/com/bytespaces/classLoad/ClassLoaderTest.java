package com.bytespaces.classLoad;


/**
 * Java 中的类加载机制（双亲委派机制）
 *
 *
 * 输出的结果：
 *       系统类加载器： sun.misc.Launcher$AppClassLoader
 *       扩展类加载器： sun.misc.Launcher$ExtClassLoader
 *       引导类加载器： null
 *
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        // 最后当loader=null的时候。这个时候loader代表的是引导类加载器BootStrap
        // System.out.println(loader);
    }
}
