package com.bytespaces.system.controller;

import com.bytespaces.system.entity.MyUser;
import com.bytespaces.system.servire.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    @GetMapping("/select")
    public List<MyUser> select() {
        return myUserService.getUserList();
    }

    @PostMapping("/insert")
    public int insert(MyUser user) {
        return myUserService.save(user);
    }

    @GetMapping(value = "/getobj/{id}")
    @ResponseBody
    public Map<String, Object> getStorage(@PathVariable("id") Integer id) {
        MyUser userInfo = myUserService.selectById(id);
        Map<String, Object> mapData = new HashMap<>(8);
        mapData.put("data",userInfo);
        return mapData;
    }

}
