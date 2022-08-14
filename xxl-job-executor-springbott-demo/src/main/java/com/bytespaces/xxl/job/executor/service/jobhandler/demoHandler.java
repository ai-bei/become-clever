package com.bytespaces.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class demoHandler {
    private static Logger logger = LoggerFactory.getLogger(demoHandler.class);


    @XxlJob("hello")
    public void one(){
        // XxlJobHelper 收集日志
        XxlJobHelper.log("XXL-JOB, Hello World.");
        // 控制台打印日志
        logger.info("## hello 任务开始执行。。。。。。。。。。");
    }



}
