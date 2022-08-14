package com.bytespaces;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Document: https://nacos.io/zh-cn/docs/quick-start-spring-boot.html
 * <p>
 * Nacos 控制台添加配置：
 * <p>
 * Data ID：example
 * <p>
 * Group：DEFAULT_GROUP
 * <p>
 * 配置内容：useLocalCache=true
 */

/**
 *
 * 如果 springboot的版本不一致，会导致报错 ： exception is java.lang.NoClassDefFoundError: org/springframework/boot/context/properties/ConfigurationBeanFactoryMetadata
 * 切换成 2.2.4.RELEASE 版本后报错信息没有了。
 *
 *
 */

@SpringBootApplication

/**
 * 这里需要注意， dataId 这里一定需要配置文件后缀类型 ，否则读取不到配置文件
 */

@NacosPropertySource(dataId = "springboot-nacos-use.yml", autoRefreshed = true)

public class NacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }
}