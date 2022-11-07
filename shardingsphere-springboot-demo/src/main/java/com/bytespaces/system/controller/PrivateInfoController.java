package com.bytespaces.system.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bytespaces.common.AjaxResult;
import com.bytespaces.system.entity.PrivateInfo;
import com.bytespaces.system.servire.PrivateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2010-2022,
 * FileName:     PrivateInfoController
 * Author:       shine
 * Date:         2022/11/5 15:32
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 * @author shine
 */
@RestController
@RequestMapping("/createInfoData")
public class PrivateInfoController {

    @Autowired
    private PrivateInfoService service;

    @PostMapping(value = "/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody PrivateInfo privateInfo) {
        UpdateWrapper<PrivateInfo> objectUpdateWrapper = new UpdateWrapper<PrivateInfo>()
                .eq("union_key",privateInfo.getUnionKey());
        return AjaxResult.success(service.saveOrUpdate(privateInfo,objectUpdateWrapper));
    }

    @PostMapping(value = "/saveOrUpdateBatch")
    public AjaxResult saveOrUpdateBatch(@RequestBody List<PrivateInfo> privateInfos) {
        return AjaxResult.success(service.saveOrUpdateBatch(privateInfos));
    }


}
