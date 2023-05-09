package com.bytespaces.SignatureDemo;

import java.util.*;

/**
 * Copyright (C), 2010-2023
 * FileName:     SortMap
 * Author:       shine
 * Date:         2023/5/5 14:02
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class SortMap {

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();
//        param.put("card_id","81000224401");
//        List<String> orderList = new ArrayList<>();
//        orderList.add("AAAAA");
//        orderList.add("BBBBB");
//        param.put("order_list", JSONUtil.toJsonStr(orderList));
//        param.put("ts","1532346339");
//        param.put("sign_type","sha1withrsa");
        param.put("ykt_id","1");
        param.put("card_id","2");
        param.put("wx_sp_id","3");


        String s = sortMap(param);
        System.out.println(s);
    }









    public static String sortMap(Map<String, String> param){
        StringBuilder result = new StringBuilder();
        Collection<String> keySet = param.keySet();
        List<String> list = new ArrayList<String>(keySet);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) {
            String key = list.get(i);
            if("symmetricKey".equals(key)){
                continue;
            }
            if(param.get(key) == null || "".equals(param.get(key).trim())){
                continue;
            }
            result.append(key).append("=").append(param.get(key)).append("&");
        }
        return result.substring(0, result.length() - 1);
    }
}
