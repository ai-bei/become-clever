package com.bytespaces.system.pojo;

import lombok.Data;

/**
 * 用户
 * @author shine
 */
@Data
public class User {

    private String username;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
