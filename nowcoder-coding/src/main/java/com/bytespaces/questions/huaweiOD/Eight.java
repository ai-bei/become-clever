package com.bytespaces.questions.huaweiOD;

import java.util.Scanner;

/**
 * 字符串序列判定
 *
 * 输入描述:
 * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。
 * 先输入S，再输入L，每个字符串占一行。
 *
 * 输出描述:
 * S串最后一个有效字符在L中的位置。（首位从0开始计算，无有效字符返回-1）
 * 示例1
 * 输入
 * ace
 * abcde
 * 输出
 * 4
 * 示例2
 * 输入
 * fgh
 * abcde
 * 输出
 * -1
 *
 *
 * @author shine
 */
public class Eight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res= -1;
        String s = in.nextLine();
        String l = in.nextLine();
        int a1=0,a2=0;
        if(s.length()>0 && l.length()>0){
            while(a1<s.length()&& a2<l.length()){
                System.out.println("比较的下标: a1 = " + a1 + "，a2 = " + a2);
                if(s.charAt(a1) == l.charAt(a2)){
                    a1++;
                    res=a2;
                    System.out.println("char相等改变a1和a2的值: a1 = " + a1 + "，a2 = " + a2);
                }
                a2++;
                System.out.println("a2的值每次加一: a2 = " + a2 );
                System.out.println("----------- end ---------------");
            }
        }
        System.out.println(res);
    }
}
