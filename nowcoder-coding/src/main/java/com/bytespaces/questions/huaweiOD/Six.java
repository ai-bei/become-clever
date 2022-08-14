package com.bytespaces.questions.huaweiOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 给定两个整数数组array1、array2，数组元素按升序排列。假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值
 * @author shine
 */
public class Six {


    public static void main(String[] args) {
        System.out.println(arraydoubleres());
    }
    public static int arraydoubleres(){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int k = sc.nextInt();
        int m= 0;
        int[] str11 = getarray(str1);
        int[] str22 = getarray(str2);
        ArrayList<Integer> arraylist = new ArrayList<>(str11.length * str22.length);
        for(int i : str11){
            System.out.println("str11----------->"+i);
            for(int j : str22){
                System.out.println("str11----------->"+i);
                arraylist.add(i + j);
            }
        }
        Collections.sort(arraylist);
        for(int i = 0 ; i < k ; i ++){
            m += arraylist.get(i);
        }
        return m;
    }
    public static int[] getarray(String str){
        String[] str11 = str.split(" ");
        int[] str111 = new int[str11.length - 1];
        for (int i = 1 ; i < str11.length ; i++){
            str111[i - 1] = Integer.parseInt(str11[i]);
        }
        return str111;
    }




//
//    public static void main(String[] args)
//    {
//        Scanner scanner=new Scanner(System.in);
//        int len_1=scanner.nextInt();
//        int[] arr_1=new int[len_1];
//        for(int dim_0=0;dim_0<len_1;dim_0++)
//            arr_1[dim_0]=scanner.nextInt();
//        int len_2=scanner.nextInt();
//        int[] arr_2=new int[len_2];
//        for(int dim_0=0;dim_0<len_2;dim_0++) {
//            arr_2[dim_0]=scanner.nextInt();
//        }
//        int k=scanner.nextInt();
//        int[] arr_sum=new int[len_1*len_2];
//        int arr_sum_index=0;
//        for(int dim_0=0;dim_0<len_1;dim_0++)
//        {
//            for(int dim_1=0;dim_1<len_2;dim_1++)
//                arr_sum[arr_sum_index++]=arr_1[dim_0]+arr_2[dim_1];
//        }
//        Arrays.sort(arr_sum);
//        long result=0;
//        for(int dim_0=0;dim_0<k;dim_0++) {
//            result+=arr_sum[dim_0];
//        }
//        System.out.println(result);
//    }

}
