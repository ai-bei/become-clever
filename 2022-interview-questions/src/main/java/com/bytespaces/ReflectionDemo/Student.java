package com.bytespaces.ReflectionDemo;

/**
 * @author shine
 */
public class Student {
    private int id;
    String name;
    protected boolean sex;
    public float score;


    public Student() {
    }

    public void outStr(String str){
        System.out.println("AAAAAAAAA + " + str );
    }

    public String returnStr(){
        return  "AAAAAAAAA + ";
    }
}
