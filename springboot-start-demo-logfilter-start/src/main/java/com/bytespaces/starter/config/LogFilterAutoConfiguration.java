package com.bytespaces.starter.config;


import com.bytespaces.starter.filter.LogFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author shine
 */
@Configuration
@ConditionalOnClass({LogFilterRegistrationBean.class, LogFilter.class})
public class LogFilterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(LogFilterRegistrationBean.class)
    public LogFilterRegistrationBean logFilterRegistrationBean() {
        return new LogFilterRegistrationBean();
    }

}
