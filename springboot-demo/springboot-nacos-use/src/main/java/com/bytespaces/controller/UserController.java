package com.bytespaces.controller;


import com.bytespaces.model.User;
import com.bytespaces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/getInfoById")
    @ResponseBody
    public User get(@RequestParam int id) {
        return userService.findById(id);
    }
}