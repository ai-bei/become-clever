package com.bytespaces.dao;

import com.bytespaces.entity.SysRoleEntity;
import com.bytespaces.util.BaseDao;

/**
 * 角色管理
 *
 * @author Annicko
 * 
 */
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

    /**
     * 更新角色
     *
     * @param role SysRoleEntity
     */
    void updateNoMapper(SysRoleEntity role);

}
