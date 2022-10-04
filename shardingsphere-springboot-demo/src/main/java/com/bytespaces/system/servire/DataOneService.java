package com.bytespaces.system.servire;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bytespaces.system.entity.DataOne;
import com.bytespaces.system.pojo.vo.BaseParams;

import java.util.List;

/**
 * Copyright (C), 2010-2022, 广州广电运通智能科技有限公司
 * FileName:     DataOneService
 * Author:       shine
 * Date:         2022/10/4 11:06
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
public interface DataOneService extends IService<DataOne> {
    /**
     * 保存用户信息
     * @param entity
     * @return
     */
//
//    @Override
//    int save(DataOne entity);

    /**
     * 查询所以用户信息
     * @return
     */
    List<DataOne> getUserList(DataOne one);

    /**
     * queryList
     * @param baseParams
     * @return
     */
    List<DataOne> queryList(BaseParams baseParams);

//    /**
//     * saveOrUpdate
//     * @param one
//     * @return
//     */
//    @Override
//    int saveOrUpdate(DataOne one);

    /**
     *
     * @param id
     * @return
     */
    DataOne selectById(Integer id);


}
