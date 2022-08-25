package com.bytespaces.cglib.demo.base;


/**  理解cglib的原理
 * cglib是利用生成子类继承父类的方法实现的动态代理.
 * 从demo中可以看出：
 *  我并未用静态代理，也没有用proxy类去实现，就是单纯的继承关系。
 */
public class test {

    public static void main(String[] args) {
        Singer singer = new SingerSub();
        singer.singing();
        singer.dance();
    }

}
