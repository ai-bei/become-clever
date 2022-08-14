package com.bytespaces;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * @author shine
 */
@SpringBootApplication
@MapperScan("com.bytespaces.system.mapper")
public class SpringSecurityApplicationFour {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplicationFour.class);
    }
}
