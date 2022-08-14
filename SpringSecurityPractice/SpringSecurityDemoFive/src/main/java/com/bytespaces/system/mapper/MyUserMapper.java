package com.bytespaces.system.mapper;

import com.bytespaces.system.entity.MyUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author shine
 */
@Component
public interface MyUserMapper {

    @Select("SELECT * FROM myuser WHERE username=#{username}")
    MyUser findByUserName(@Param("username") String username);
}
