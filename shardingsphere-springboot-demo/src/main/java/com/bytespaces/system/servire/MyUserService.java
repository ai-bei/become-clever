package com.bytespaces.system.servire;

import com.bytespaces.system.entity.MyUser;

import java.util.List;

public interface MyUserService {
    /**
     * 保存用户信息
     * @param entity
     * @return
     */

    int save(MyUser entity);

    /**
     * 查询所以用户信息
     * @return
     */
    List<MyUser> getUserList();

    /**
     *
     * @param id
     * @return
     */
    MyUser selectById(Integer id);

}
