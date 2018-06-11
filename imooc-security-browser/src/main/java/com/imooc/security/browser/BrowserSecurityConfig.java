package com.imooc.security.browser;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author zhy
 * @version 1.0
 * @classDesc: 身份认证配置类
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Resource(name = "imoocAuthenticationSuccessHandler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource(name = "imoocAuthenticationFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();


        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(), "/code/image")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
