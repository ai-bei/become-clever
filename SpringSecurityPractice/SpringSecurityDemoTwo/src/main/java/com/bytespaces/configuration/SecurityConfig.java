package com.bytespaces.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * security 配置
 *
 * WebSecurityConfigurerAdapter 配置 HttpSecurity 的方式已经被弃用了
 *
 * 使用 org.springframework.security.web.SecurityFilterChain Bean 来配置 HttpSecurity
 * 或使用 WebSecurityCustomizer Bean 来配置
 * @author shine
 */
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // antMatchers采用 ANT 模式的URL配置器。
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                // permitAll() 设置公开权限
                .antMatchers("/app/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        // 将用户的数据源存放在缓存中
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("123").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123").roles("USER", "ADMIN").build());
        return manager;
    }

    /**
     *  5.x版本后默认启动了委派密码编码器
     *  这里先将密码编码器设置为：NoOpPasswordEncoder
     * @return passwordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
