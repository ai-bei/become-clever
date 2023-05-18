package com.bytespaces.SignatureDemo;

/**
 * Copyright (C), 2010-2023
 * FileName:     DesDemo
 * Author:       shine
 * Date:         2023/5/12 16:25
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;

public class DesDemo {

    public static void main(String[] args) throws Exception {
        String arg0[]={""
        };
        for (int i = 0; i < arg0.length; i++) {
            System.out.println(des_decode(new Object(), arg0[i]));
        }

    }


    public static String des_encode(Object arg, String[] arg0) throws Exception{
        String arg1 = "cputest";
        Key arg2 = hex(arg1.getBytes());
        Cipher arg3 = Cipher.getInstance("DES");
        arg3.init(1, arg2);
        return byteArr2HexStr(arg3.doFinal(arg0[0].getBytes()));

    }

    public static String des_decode(Object arg, String[] arg0) throws Exception {
        String arg1 = "cputest";
        Key arg2 = hex(arg1.getBytes());
        Cipher arg3 = Cipher.getInstance("DES");
        arg3.init(2, arg2);
        return new String(arg3.doFinal(hexStr2ByteArr(arg0[0])), Charset.forName("GBK"));
    }

    public static String des_decode(Object arg, String argStr) throws Exception {
        String arg1 = "cputest";
        Key arg2 = hex(arg1.getBytes());
        Cipher arg3 = Cipher.getInstance("DES");
        arg3.init(2, arg2);
        return new String(arg3.doFinal(hexStr2ByteArr(argStr)), Charset.forName("GBK"));
    }




    private static Key hex(byte[] arg) throws Exception {
        byte[] arg0 = new byte[8];
        for(int arg1 = 0; arg1 < arg.length && arg1 < arg0.length; ++arg1) {
            arg0[arg1] = arg[arg1];
        }
        SecretKeySpec arg2 = new SecretKeySpec(arg0, "DES");
        return arg2;
    }


    public static String byteArr2HexStr(byte[] arg) throws Exception {
        int arg0 = arg.length;
        StringBuffer arg1 = new StringBuffer(arg0 * 2);
        for(int arg2 = 0; arg2 < arg0; ++arg2) {
            int arg3;
            for(arg3 = arg[arg2]; arg3 < 0; arg3 += 256) {
                ;
            }
            if(arg3 < 16) {
                arg1.append("0");
            }
            arg1.append(Integer.toString(arg3, 16));
        }
        return arg1.toString();
    }

    public static byte[] hexStr2ByteArr(String arg) throws Exception {
        byte[] arg0 = arg.getBytes();
        int arg1 = arg0.length;
        byte[] arg2 = new byte[arg1 / 2];
        for(int arg3 = 0; arg3 < arg1; arg3 += 2) {
            String arg4 = new String(arg0, arg3, 2);
            arg2[arg3 / 2] = (byte)Integer.parseInt(arg4, 16);
        }
        return arg2;
    }
}
