package com.bytespaces.config.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {
    //目标对象
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //创建代理对象
    public Object createProxy(){
        //1.创建Enhancer
        Enhancer enhancer = new Enhancer();
        //2.传递目标对象Class
        enhancer.setSuperclass(target.getClass());
        //3.设置回调操作（相当于InvocationHandler）
        enhancer.setCallback(this);

        return enhancer.create();
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //在调用目标对象方法前，统一做一些其他操作，即功能增强
        System.out.println ("例如：日志操作......");
        return method.invoke(target,args);
    }
}
