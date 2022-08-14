package com.bytespaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demo {

    @GetMapping("/demo")
    public String hello(){
        return "hello";
    }
}
