package com.bytespaces.other;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @author shine
 */
public class testOne {

    /**
     * 现在有一个字符串数组，长度不超过10，现在需要将其转为定长格式，左靠齐，右边不满空格补充，请编码实现，并注意提高性能和降低内存占用。
     */
    @Test
    public void test() {
//        String[] array = new String[]{"AAAABBB" , "BCCC", "BCCCDDD"};
//
//        convertStringArray(array);
//
//        System.out.println();
        IntStream.range(1,5).forEach(i->{
            System.out.println(i);
        });
    }

    public static void main(String[] args) {
        IntStream.range(1,5).forEach(i->{
            System.out.println(i);
        });
    }




    public void convertStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = String.format("%-10s", array[i]); ;
        }
    }

}
