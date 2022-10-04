package com.bytespaces.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytespaces.system.entity.DataOne;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2010-2022, 广州广电运通智能科技有限公司
 * FileName:     DataOneMapper
 * Author:       shine
 * Date:         2022/10/4 11:05
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
@Resource
public interface DataOneMapper extends BaseMapper<DataOne> {

    List<DataOne> queryList(@Param("startDate") Date startDate , @Param("endDate") Date endDate);
}
