package com.bytespaces.myAtoi;


import java.math.BigInteger;

/**
 *  请您实现一个  myAtoi(String str) 函数，使得能将字符串转换成一个  32  位的有符号整数
 */
public class myAtoi {

    public static void myAtoiDemo(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char c = arr[i];
            byte b = (byte) c ;
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        myAtoiDemo("B");


        BigInteger value = new BigInteger("B", 32);

        System.out.println(value);

    }

}
