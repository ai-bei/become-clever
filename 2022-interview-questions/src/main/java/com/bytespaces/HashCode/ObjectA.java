package com.bytespaces.HashCode;

import java.util.Objects;

public class ObjectA {
    private String usernaem;

    public ObjectA(String usernaem){
        this.usernaem = usernaem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ObjectA)) {
            return false;
        }
        ObjectA objectA = (ObjectA) o;
        return Objects.equals(usernaem, objectA.usernaem);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(usernaem);
//    }
}
