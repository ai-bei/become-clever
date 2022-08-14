package com.bytespaces.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class NacosConfig {
    /*nacos注册服务*/
    @NacosInjected
    private NamingService namingService;

    @NacosValue("${spring.application.name}")
    private String applicationName;

    @NacosValue("${server.port}")
    private Integer serverPort;

    //java项目www.fhadmin.org
    @PostConstruct
    public void run() throws Exception {
        // 通过Naming服务注册实例到注册中心
        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
    }
}
