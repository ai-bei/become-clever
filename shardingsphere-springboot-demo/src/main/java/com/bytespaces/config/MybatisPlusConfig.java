package com.bytespaces.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bytespaces.system.mapper")
public class MybatisPlusConfig {
}
