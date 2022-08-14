package com.bytespaces.system.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shine
 */
@RestController
public class LoginController {

    @GetMapping("/")
    public String hello() {
        return "hello,spring security.";
    }




}
