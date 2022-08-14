package com.bytespaces.questions.huaweiOD;

/**
 * @author shine
 */
public class DemoOther {
    public static void main(String[] args) {
        DemoOther demoOther = new DemoOther();
//        demoOther.testOne();
        demoOther.testTwo("abc2234019A334bc");

    }

    public void testOne(){
        String line = "abc2234019A334bc";
        char[] chars = line.toCharArray();
        int max = 0 , number = 0 ;
        char list ='a';
        for (char num : chars) {
            if(Character.isDigit(num)){
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
            }else {
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

    public void testTwo(String line){
        char[] chars = line.toCharArray();
        int max = 0 , number = 0 ;
        char list ='a';
        for (char num : chars) {
            if(Character.isDigit(num)){
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
            }else {
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
