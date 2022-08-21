package com.bytespaces.service;

/**
 *
 */
public interface UserService {
    void login(String username, String password);
    void regist();
    void search();
    void update();
}
