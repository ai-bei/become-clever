package com.bytespaces.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${serverPort:1800}", autoRefreshed = true)
    private String serverPort;

    @NacosValue(value = "${spring.datasource.url:url}", autoRefreshed = true)
    private String springDatasourceUrl;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return springDatasourceUrl + "============" + serverPort;
    }
}