package com.bytespaces.questions.huaweiOD;

import java.util.Scanner;

/**
 * 补种未成活胡杨
 * @author shine
 */
public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总种植数量
        String totalStr = scanner.nextLine();
        // 未成活胡杨数量
        String deathStr = scanner.nextLine();
        // posStr 代表未存活的胡杨树的序号 2 4 6
        // 空格分隔的数，按编号从小到大排列
        String posStr = scanner.nextLine();
        // 最多可以补种的数量
        String maxStr = scanner.nextLine();
        int total = Integer.parseInt(totalStr);
        int death = Integer.parseInt(deathStr);
        String[] posStrs = posStr.split(" ");

        int[] pos = new int[posStrs.length+2];
        pos[0]=0;
        pos[posStrs.length + 1]=total+1;
        for (int i = 0; i < posStrs.length; i++) {
            pos[i+1] = Integer.parseInt(posStrs[i]);
        }
        int max = Integer.parseInt(maxStr);
        if (total < 0 || death < 0 || max < 0 || posStrs.length!=death) {
            return;
        }
        if (death == 0){
            System.out.println(total);
        }else if (max >= death) {
            System.out.println(total);
        }else {
            int a = 0;

            System.out.println("max = " + max);
            System.out.print("pos[] = ");
            for (int i = 0; i < pos.length; i++) {
                System.out.print(pos[i] + ",");
            }
            System.out.println();



            for (int i = 0; i < pos.length-max-1; i++) {
                a = Math.max(a,pos[i+max+1]-pos[i]-1);
                System.out.println("第 i=" + i +", pos[i+max+1] = " + pos[i+max+1]);
                System.out.println("第 i=" + i +", pos[i] = " + pos[i]);
                System.out.println("第 i=" + i +", a = " + a);
            }
            System.out.println(a);
        }
    }
}
