package com.bytespaces.system.servire.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bytespaces.system.entity.DataOne;
import com.bytespaces.system.mapper.DataOneMapper;
import com.bytespaces.system.pojo.vo.BaseParams;
import com.bytespaces.system.servire.DataOneService;
import com.bytespaces.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2010-2022, 广州广电运通智能科技有限公司
 * FileName:     DataOneServiceImpl
 * Author:       shine
 * Date:         2022/10/4 11:07
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
@Service
public class DataOneServiceImpl extends ServiceImpl<DataOneMapper, DataOne> implements DataOneService {

    @Autowired
    private DataOneMapper dataOneMapper;


    @Override
    public List<DataOne> getUserList(DataOne one) {
        QueryWrapper<DataOne> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("*"); 使用 * 查询会导致查询的字段都是null
        queryWrapper.select("id,username,password,create_date");
        queryWrapper.between("create_date", DateUtil.strBeautyShort2Date("2022-08-01"),DateUtil.strBeautyShort2Date("2022-09-31"));
        return dataOneMapper.selectList(queryWrapper);
    }

    @Override
    public List<DataOne> queryList(BaseParams baseParams) {
        Date startDate = DateUtil.strBeautyShort2Date(baseParams.getStartDate());
        Date endDate = DateUtil.strBeautyShort2Date(baseParams.getEndDate());
        return dataOneMapper.queryList(startDate,endDate);
    }


    @Override
    public DataOne selectById(Integer id) {
        return dataOneMapper.selectById(id);
    }


}
