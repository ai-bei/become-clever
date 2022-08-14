package com.bytespaces.questions.huaweiOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
 * 输入描述:
 * 输入为空格分开的小朋友编号和是否同班标志。
 * 比如：6/N 2/Y 3/N 4/Y，表示共4位小朋友，2和6同班，3和2不同班，4和3同班。
 * 其中，小朋友总数不超过999，每个小朋友编号大于0，小于等于999。
 * 不考虑输入格式错误问题。
 *
 * 输出描述:
 * 输出为两行，每一行记录一个班小朋友的编号，编号用空格分开。且：
 * 1、编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行。
 * 2、若只有一个班的小朋友，第二行为空行。
 * 3、若输入不符合要求，则直接输出字符串ERROR。
 * 示例1
 * 输入
 * 1/N 2/Y 3/N 4/Y
 * 输出
 * 1 2
 * 3 4
 * 说明
 * 2的同班标记为Y，因此和1同班。
 * 3的同班标记为N，因此和1、2不同班。
 * 4的同班标记为Y，因此和3同班。
 * 所以1、2同班，3、4同班，输出为
 * 1 2
 * 3 4
 * @author shine
 */
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str= "14/N 18/Y 23/N 33/Y 7/Y 62/N";
        boolean flag=true;
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            String[] split = s[i].split("/");
            if(split.length!=2){
                System.out.println("ERROR");
                return;
            }
            try {
                int v1 = Integer.valueOf(split[0]);
                if(v1<=0 || v1>999){
                    System.out.println("ERROR");
                    return;
                }
                if(i==0){
                    flag=true;
                }else if("Y".equals(split[1])){
                    flag=flag;
                }else if("N".equals(split[1])){
                    flag=!flag;
                }else{
                    System.out.println("ERROR");
                    return;
                }
                if(flag){
                    one.add(v1);
                }else{
                    two.add(v1);
                }
            }catch (Exception e){
                System.out.println("ERROR");
                return;
            }
        }
        if(!one.isEmpty() && !two.isEmpty()){
            sorted(one);
            sorted(two);
            if(one.get(0)<two.get(0)){
                show(one);
                show(two);
            }else{
                show(two);
                show(one);
            }
        }else if(two.isEmpty()){
            sorted(one);
            show(one);
        }
    }
    public static void sorted(List<Integer> list){
        Collections.sort(list);
    }
    public static void show(List<Integer> list){
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }
}
