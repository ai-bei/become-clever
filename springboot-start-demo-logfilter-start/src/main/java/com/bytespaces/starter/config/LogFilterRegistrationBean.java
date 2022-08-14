package com.bytespaces.starter.config;

import com.bytespaces.starter.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * @author shine
 */
public class LogFilterRegistrationBean extends FilterRegistrationBean<LogFilter> {

    public LogFilterRegistrationBean() {
        super();
        this.setFilter(new LogFilter()); //添加LogFilter过滤器
        this.addUrlPatterns("/*"); // 匹配所有路径
        this.setName("LogFilter"); // 定义过滤器名
        this.setOrder(1); // 设置优先级

    }
}
