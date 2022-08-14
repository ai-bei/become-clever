package com.bytespaces.controller;

import com.bytespaces.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") String id){
        return testService.viewInit(id);
    }
}
