package com.bytespaces.starter.annotation;


import com.bytespaces.starter.config.EnableLogFilterImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启过滤器日志
 *
 * Created by shine on 2018/4/9.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(EnableLogFilterImportSelector.class) //引入LogFilterAutoConfiguration配置类
public @interface EnableLogFilter {
}
