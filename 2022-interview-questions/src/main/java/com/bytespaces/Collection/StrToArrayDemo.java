package com.bytespaces.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2010-2022,
 * FileName:     StrToArrayDemo
 * Author:       shine
 * Date:         2023/4/21 15:01
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class StrToArrayDemo {

    /**
     * 字符 str 转 Array
     * @param args
     */
    public static void main(String[] args) {
        String str = "[12,13,232]" ;
        List<Integer> integerList = Arrays.stream(str.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        
    }
}
