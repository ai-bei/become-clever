package com.bytespaces.questions.huaweiOD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
 * @author shine
 */
public class Nine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            String[] numArr = input.split(",");
            List<String> list = Arrays.asList(numArr);
            list.sort((next, pre) -> next.length() == pre.length() ? pre.compareTo(next) : (pre + next).compareTo(next + pre));
            StringBuilder sb = new StringBuilder();
            for (String num : list) {
                sb.append(num);
            }
            System.out.println(sb);
        }
    }
}
