package com.bytespaces.system.servire.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bytespaces.system.entity.MyUser;
import com.bytespaces.system.mapper.MyUserMapper;
import com.bytespaces.system.servire.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private MyUserMapper myUserMapper;


    @Override
    public int save(MyUser entity) {
        return myUserMapper.insert(entity);
    }

    @Override
    public List<MyUser> getUserList(MyUser user) {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        return myUserMapper.selectList(queryWrapper);
    }

    @Override
    public MyUser selectById(Integer id) {
        return myUserMapper.selectById(id);
    }
}
