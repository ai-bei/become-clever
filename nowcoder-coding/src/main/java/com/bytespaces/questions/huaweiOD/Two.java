package com.bytespaces.questions.huaweiOD;

import java.util.Scanner;

/**
 * 题目：
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的最长的非严格递增连续数字序列的长度（比如12234属于非严格递增连续数字序列）。
 * 输入
 * abc2234019A334bc
 * 输出
 * 4
 * 说明
 * 2234为最长的非严格递增连续数字序列，所以长度为4。
 * @author shine
 */
public class Two {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        char[] chars = line.toCharArray();
        int number=0,max=0;
        char list ='a';
        for (char num : chars) {
            if (Character.isDigit(num)) {
                System.out.println("比较的字符开始 --> " + num);
                System.out.println("number --> " + number);
                System.out.println("max --> " + max);
                System.out.println("list --> " + list);
                System.out.println("-----------------------------");

                if (number==0){
                    number++;
                }else if (num >= list){
                    number++;
                }else {
                    if (number >max){
                        max = number;
                    }
                    number=1;
                }
                list = num;
            } else {
                if (number > max) {
                    max = number;
                }
                number = 0;
                list = 'a';
            }
        }
        if (number > max){
            max = number;
        }
        System.out.println(max);
    }
}
