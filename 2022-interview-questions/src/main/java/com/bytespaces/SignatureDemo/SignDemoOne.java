package com.bytespaces.SignatureDemo;

import cn.hutool.core.codec.Base64;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Copyright (C), 2010-2022,
 * FileName:     SignDemoOne
 * Author:       shine
 * Date:         2023/4/24 15:36
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class SignDemoOne {

    private final static String SIGN_TYPE_RSA = "RSA";
    private final static String SIGN_ALGORITHMS = "SHA1WithRSA";
    private final static String CHARSETTING = "UTF-8";



    public static void main(String[] args) {
       String signQueryContent = String.format("contract_code=%s&sign_type=%s&ts=%s&version=%s&ykt_id=%s","1","2","3","4","5");
       String signStr = sign(signQueryContent, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJthV6Muh1BP/7XiJkxuv+lLMPzHI8hRxBKlMmDRcyPFOjXJEYHW1cFxJtDuFM7njQLMmQOuI8ri0IoY94zbGZFLuNNWs5xoJgvs3A2Uvw+7oP33OJJ+tM7693l1zzr6RDJ4LPPUQ5sxe5zxHB4k/4iHlMFQZsGyiFIKxJ3V8pePAgMBAAECgYBMB4Gec3H6tmplUVd0Juz49rXtunOj3X6XsQXJojM42ZT2JIDQi5LkqL1ZlmXQKDUznXFx/4+8AugP6s+WuM71KXe6K01JhQJeaKoQGY+GRxpqy8yYDDQ4ndT8CeYPA0fE5c+Q+BUwIINrTjQIOX9mCYYWkO7d2ILuglnmkwTzwQJBANw73iCMB+0uA1/gU30CW2N5mfAYxVD9PrN/5b0vI0rkUUACQSM814abDWynQ4HVkNOOc7jJTa5fv/EDZW89rzcCQQC0nTZUNQRSADZx5q1zWnuEHm9AEGlSBZE4gpQlLYttqvuVLnGd2ZQjjWknaVbPK2BWZgjyKcXU1C6O0JKBoRZpAkArgth77a6TOYgJJTTZeeG8YYX8Xah+O8prhFVLb0i1vy4eS1O7NoYOXgvk75byy9L1OSu70mm6jchKQbWEqNc5AkBu6skth22CyjylUEuetqd56JLbnfh/9YlMUeyWtFSW4dUktWPy02bFOpekK22zRmkgRgMibILgg/mfnPkMAJhZAkEAll39mQ9ydJq1BTIAj5dnKVKpsWIA1M1htgyZRtYu112o8/jLg9Gnk07i0EV7hkltD/0ZUztSfXJDbbz/xAsoeB==");
        System.out.println("signStr: " + signStr);
    }


    /**
     * 加签
     *
     * @param content
     * @param privateKey
     * @return
     */
    public static String sign(String content, String privateKey) {
        try {
            PrivateKey priKey = getPrivateKey(privateKey);
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(CHARSETTING));
            byte[] signed = signature.sign();
            return Base64.encode(signed);
        } catch (Exception e) {
            System.out.println("加签异常");
        }
        return null;
    }

    /**
     * 验签
     *
     * @param content
     * @param sign
     * @param public_key
     * @return
     */
    public static boolean verify(String content, String sign, String public_key) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(SIGN_TYPE_RSA);
            byte[] encodedKey = Base64.decode(public_key);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(CHARSETTING));
            boolean bverify = signature.verify(Base64.decode(sign));
            return bverify;
        } catch (Exception e) {
            System.out.println("验签异常:{}" + ExceptionUtils.getStackTrace(e));
        }
        return false;
    }


    /**
     * 得到私钥
     *
     * @param key 密钥字符串(经过base64编码)
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64.decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(SIGN_TYPE_RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;

    }
}
