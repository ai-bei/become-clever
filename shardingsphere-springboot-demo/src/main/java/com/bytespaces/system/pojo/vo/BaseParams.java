package com.bytespaces.system.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2010-2022, 广州广电运通智能科技有限公司
 * FileName:     baseParams
 * Author:       shine
 * Date:         2022/10/4 14:40
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
@Data
public class BaseParams implements Serializable {
    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
