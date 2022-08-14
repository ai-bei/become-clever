package com.bytespaces.system.servire;

import com.bytespaces.system.entity.MyUser;
import com.bytespaces.system.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 重新 UserDetailsService 中loadUserByUsername的方法，获取数据库中的用户信息
 * @author shine
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库尝试读取该用户
        MyUser user = myUserMapper.findByUserName(username);
        // 用户不存在，抛出异常
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 将数据库形式的roles解析为UserDetails的权限集
        // AuthorityUtils.commaSeparatedStringToAuthorityList是Spring Security
        //提供的用于将逗号隔开的权限集字符串切割成可用权限对象列表的方法
        // 当然也可以自己实现，如用分号来隔开等，参考generateAuthorities
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
        return user;
    }
}