package com.bytespaces.thread.base;

public class FirstThreadTest extends Thread{
    int i = 0;
    //重写 run 方法，run 方法的方法体就是现场执行体
    public void run() {
        for(i= 0; i < 100; i++){
            System.out.println(getName() + " " + i);
        }
    }
    public static void main(String[] args) {
        for(int i = 0;i< 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" : "+i);
            if(i==20)
            {
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }
}
