package com.bytespaces.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Copyright (C), 2010-2022, 广州广电运通智能科技有限公司
 * FileName:     DataOne
 * Author:       shine
 * Date:         2022/10/4 11:01
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dataone")
public class DataOne {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

}
