package com.bytespaces.cglib.demo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetCglib implements MethodInterceptor {
    private ZStar zStar;
    public TargetCglib(ZStar zStar) {
        this.zStar = zStar;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("签合同");
        Object invoke = methodProxy.invokeSuper(o, objects);//调用原方法
        //Object invoke = method.invoke(zStar, objects);
        //Object invoke = methodProxy.invokeSuper(zStar, objects);
        System.out.println("收钱");
        return invoke;
    }
}