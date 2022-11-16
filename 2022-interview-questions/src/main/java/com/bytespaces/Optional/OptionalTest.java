package com.bytespaces.Optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Copyright (C), 2010-2022,
 * FileName:     OptionalTest
 * Author:       shine
 * Date:         2022/11/7 17:00
 * Description:  测试 OptionalTest
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public class OptionalTest {

    @Test
    public void testOne(){

        /*   Optional.ofNullable  这个方法识别不了  “”（空字符串）   */
        String objA = "";
        String one = Optional.ofNullable(objA).orElse("A");
        System.out.println("system out info : " + one);


        String objB = null;
        String two = Optional.ofNullable(objB).orElse("B");
        System.out.println("system out info : " + two);


    }


}
