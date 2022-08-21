package com.bytespaces.service.Impl;

import com.bytespaces.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void login(String username, String password) {
        System.out.println ("登录---> username ：" + username);
    }

    @Override
    public void regist() {
        System.out.println ("注册");
    }

    @Override
    public void search() {
        System.out.println ("userService search...");
    }

    @Override
    public void update() {
        System.out.println ("update...");
    }
}
