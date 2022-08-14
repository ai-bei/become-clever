package com.bytespaces.configuration;


import com.bytespaces.authorization.SecurityAuthenticationFailureHandler;
import com.bytespaces.authorization.SecurityAuthenticationSuccessHandler;
import com.bytespaces.filter.VerificationCodeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**", "/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureHandler(new SecurityAuthenticationFailureHandler())
                .successHandler(new SecurityAuthenticationSuccessHandler())
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .csrf().disable();
        // 将过滤器添加在UsernamePasswordAuthenticationFilter之前
        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
