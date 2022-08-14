package com.bytespaces.service;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class TestService {
    private String totoService = "provide-service";

    @Resource
    private RestTemplate restTemplate;

    @NacosInjected
    private NamingService namingService;

    // @GetMapping(value = "/table/{Id}")
    public String viewInit(String Id) {
        Instance instance;
        try {
            instance = namingService.selectOneHealthyInstance(totoService);
            String url = String.format("http://%s:%d/getInfoById?id=" + Id, instance.getIp(), instance.getPort());
            String result = restTemplate.getForObject(url, String.class);
            return result;
        } catch (NacosException e) {
            System.out.println("创建代办报错！！！" + e.getMessage());
            return "";
        }
    }
}
