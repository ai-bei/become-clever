package com.bytespaces.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bytespaces.dao.SysUserLoginLogDao;
import com.bytespaces.entity.SysUserLoginLogEntity;
import com.bytespaces.service.SysUserLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 用户登录日志
 *
 * @author Annicko
 * 
 */
@Service
public class SysUserLoginLogServiceImpl extends ServiceImpl<SysUserLoginLogDao, SysUserLoginLogEntity>
        implements SysUserLoginLogService {

    @Override
    public Page<SysUserLoginLogEntity> getSelf(Integer offset, Integer limit, Long adminId, String loginIp, String sort,
                                               Boolean order) {
        Wrapper<SysUserLoginLogEntity> wrapper = new EntityWrapper<SysUserLoginLogEntity>();
        wrapper.eq("user_id", adminId);
        if (StringUtils.isNoneBlank(sort) && null != order) {
            wrapper.orderBy(sort, order);
        }
        if (StringUtils.isNoneBlank(loginIp)) {
            wrapper.like("login_ip", loginIp);
        }
        Page<SysUserLoginLogEntity> page = new Page<>(offset, limit);
        return this.selectPage(page, wrapper);
    }

}
