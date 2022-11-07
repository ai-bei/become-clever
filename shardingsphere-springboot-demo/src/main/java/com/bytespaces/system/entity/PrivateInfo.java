package com.bytespaces.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2010-2022, 广州广电运通智能科技有限公司
 * FileName:     PrivateInfo
 * Author:       shine
 * Date:         2022/11/5 15:43
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("private_info")
public class PrivateInfo {


    @TableId(type = IdType.AUTO)
    private Long id;


//    @TableId(type = IdType.INPUT)
    private String unionKey;


    private String username;

    private String password;

    private String info;

}
