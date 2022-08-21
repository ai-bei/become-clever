package com.bytespaces;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootAopDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopDemoApplication.class);
    }
}
