package com.bytespaces.questions.huaweiOD;

import java.util.Scanner;

/**
 * 一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
 *
 */
public class Five {
    public static void main(String[] args) {
        while (true){//只是做个循环输入方便测试
            System.out.println("请输入一个整数：");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            mothd(n);
        }
    }
    public static void mothd(int n){
        int startNum = 0;
        int count = 1;
        System.out.println(n + "=" + n);
        /**
         * 研究此题发现实际上是求一个公差为1的等差数列，设首项为x,根据等差数列求和可知sum = (x+(x+(n-1)))*n/2
         * 可以推导出首项为x = (sum - n*(n-1)/2) / n = (2*sum -n*(n-1)) / 2*n
         * 由于不知道n具体为几项，则通过循环获取，其中若要n最大时，可考虑首项为1
         * 即可得到sum >= (1+(1+(n-1)))*n/2
         * 推导出sum >= n*(n+1)/2 可得出 n*(n+1)<=2*sum
         */
        for (int i = 2; i * (i + 1)<= 2 * n; i++) {//此处变量设置n为要表示的整数，i为项数，根据题目要求可知i最小为两项
            if((2 * n - i * (i - 1)) % (2 * i) == 0){//求余，若除数为零说明此时的项数i可求得满足条件的首项
                startNum = (2 * n - i * (i - 1)) / (2 * i);//首项
                if (startNum>0){//排除可能为负数的情况
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        result.append(startNum++).append("+");//先打印再做变量自增
                    }
                    result.deleteCharAt(result.length()-1);
                    System.out.println(n + "=" + result);
                    count++;
                }
            }
        }
        System.out.println("可用的连续自然数表示方法共有"+count+"种");
    }
}
