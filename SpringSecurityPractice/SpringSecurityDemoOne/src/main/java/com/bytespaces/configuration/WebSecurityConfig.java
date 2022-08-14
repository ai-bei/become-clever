package com.bytespaces.configuration;


import com.bytespaces.authorization.SecurityAuthenticationFailureHandler;
import com.bytespaces.authorization.SecurityAuthenticationSuccessHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * security 配置
 *
 * WebSecurityConfigurerAdapter 配置 HttpSecurity 的方式已经被弃用了
 *
 * 使用 org.springframework.security.web.SecurityFilterChain Bean 来配置 HttpSecurity
 * 或使用 WebSecurityCustomizer Bean 来配置
 * @author shine
 */
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                // 指定登入成功后的请求路径
                .loginProcessingUrl("/login")
                // 指定成功时的处理逻辑
                .successHandler(new SecurityAuthenticationSuccessHandler())
                // 指定失败时的处理逻辑
                .failureHandler(new SecurityAuthenticationFailureHandler())
                // 使登录页不设限访问
                .permitAll()
                .and()
                .csrf().disable();
    }
}
