package com.bytespaces.system.base;

import com.bytespaces.system.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
