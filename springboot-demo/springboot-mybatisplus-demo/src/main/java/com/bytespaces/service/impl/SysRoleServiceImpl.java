package com.bytespaces.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bytespaces.dao.SysRoleDao;
import com.bytespaces.entity.SysRoleEntity;
import com.bytespaces.service.SysRoleMenuService;
import com.bytespaces.service.SysRoleService;
import com.bytespaces.service.SysUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author Annicko
 * 
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Resource
    private SysRoleMenuService sysRoleMenuService;
    @Resource
    private SysUserRoleService sysUserRoleService;

    @Override
    public List<SysRoleEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    @Transactional
    public void save(SysRoleEntity role) {
        baseMapper.insert(role);
        // 保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional
    public void update(SysRoleEntity role) {
        baseMapper.updateNoMapper(role);

        // 更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] roleIds) {
        baseMapper.deleteBatch(roleIds);
    }

    @Override
    public Page<SysRoleEntity> queryListByPage(Integer offset, Integer limit, String roleName, String sort,
                                               Boolean order) {
        Wrapper<SysRoleEntity> wrapper = new EntityWrapper<SysRoleEntity>();
        if (StringUtils.isNoneBlank(sort) && null != order) {
            wrapper.orderBy(sort, order);
        }
        if (StringUtils.isNoneBlank(roleName)) {
            wrapper.like("role_name", roleName);
        }
        Page<SysRoleEntity> page = new Page<>(offset, limit);
        return this.selectPage(page, wrapper);
    }

}
