package com.bytespaces.controller;

import com.bytespaces.config.aop.CglibProxyFactory;
import com.bytespaces.config.aop.JDKProxyFactory;
import com.bytespaces.service.Impl.UserServiceImpl;
import com.bytespaces.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
@Slf4j
@Validated
public class AopBackGroundController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/jdkproxy", method = RequestMethod.GET)
    public void testJDKProxy(){
        //JDK动态代理
        userService.login("zz","123456");
        System.out.println ("--------------JDK动态代理------------");


        UserServiceImpl userServiceImpl = new UserServiceImpl();
        JDKProxyFactory jdkProxyFactory = new JDKProxyFactory(userServiceImpl);

        /**
         *  这里 容易报错报错
         *  com.sun.proxy.$Proxy75 cannot be cast to com.bytespaces.service.UserService
         *
         *  例如下面的代码：
         *  JDKProxyFactory jdkProxyFactory = new JDKProxyFactory(UserService);
         *
         */
        UserService userServiceProxy = (UserService) jdkProxyFactory.createProxy();
        userServiceProxy.login("zz","123456");
    }


    @RequestMapping(value = "/cglibproxy", method = RequestMethod.GET)
    public void testCGLIBProxy(){
        //CGLIB动态代理
        userService.regist();
        System.out.println ("--------------CGLIB动态代理------------");
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(userService);
        UserService userServiceProxy = (UserService)cglibProxyFactory.createProxy();
        userServiceProxy.regist();
    }


    @RequestMapping(value = "/aspectJproxy", method = RequestMethod.GET)
    public void testAspectJ(){
        // UserServiceHelper
        userService.search();
    }


    @RequestMapping(value = "/aspectJproxyPoint", method = RequestMethod.GET)
    public void testPointcutAdvice(){
        // UserServiceHelper
        userService.search();
    }
}
