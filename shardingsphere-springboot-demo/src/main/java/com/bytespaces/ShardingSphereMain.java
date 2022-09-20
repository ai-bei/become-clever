package com.bytespaces;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author shine
 */
@MapperScan("com.bytespaces.system.mapper")
@SpringBootApplication
public class ShardingSphereMain {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereMain.class, args);
    }
}