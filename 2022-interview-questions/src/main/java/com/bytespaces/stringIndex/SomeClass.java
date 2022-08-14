package com.bytespaces.stringIndex;

import java.nio.charset.StandardCharsets;

public class SomeClass {
    public static void main(String[] args) {
        System.out.println(indexOf("abcabdef","ba"));
    }

    public static int indexOf(String source, String str){
        int  result = -1;
        if(str == null){
            return result;
        }
        if(str.length() == 0 || source.length() < str.length()){
            return result;
        }
        byte[] sourceBytes = source.getBytes(StandardCharsets.UTF_8);
        byte[] strBytes = str.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < sourceBytes.length; i++) {
            if(result != -1){
                break;
            }
            if(sourceBytes[i] != strBytes[0]){
                continue;
            }
            for (int j = 0; j < strBytes.length; j++) {
                if( i+j > sourceBytes.length - 1){
                    break;
                }
                if(sourceBytes[i+j] != strBytes[j]){
                    break;
                }
                if(strBytes.length - 1 == j){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}
