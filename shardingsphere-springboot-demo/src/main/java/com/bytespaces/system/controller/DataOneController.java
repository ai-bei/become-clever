package com.bytespaces.system.controller;

import com.bytespaces.common.AjaxResult;
import com.bytespaces.system.entity.DataOne;
import com.bytespaces.system.pojo.vo.BaseParams;
import com.bytespaces.system.servire.DataOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2010-2022,
 * FileName:     DateOneController
 * Author:       shine
 * Date:         2022/10/4 11:01
 * Description:
 * History:
 * <author>      <time>          <version>          <desc>
 * 作者姓名       修改时间         版本号             描述
 */
@RestController()
@RequestMapping("/dataOne")
public class DataOneController {

    @Autowired
    private DataOneService dataOneService;

    @PostMapping("/select")
    public AjaxResult select(@RequestBody DataOne one) {
        return AjaxResult.success(dataOneService.getUserList(one));
    }

    @PostMapping("/queryList")
    public AjaxResult queryList(@RequestBody BaseParams baseParams) {
        return AjaxResult.success(dataOneService.queryList(baseParams));
    }

    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody DataOne one) {
        return AjaxResult.success(dataOneService.saveOrUpdate(one));
    }

    @PostMapping("/saveOrUpdateBatch")
    public AjaxResult saveOrUpdateBatch(@RequestBody List<DataOne> list) {
        return AjaxResult.success(dataOneService.saveOrUpdateBatch(list));
    }

}
