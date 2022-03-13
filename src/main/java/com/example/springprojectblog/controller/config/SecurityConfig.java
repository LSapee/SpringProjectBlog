package com.example.springprojectblog.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것
@Configuration  //빈 등록
@EnableWebSecurity      //필터링 권한 
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
            .antMatchers("/auth/**")//권한 허용 /auth는 누구나 가능
            .permitAll()
            .anyRequest()//이외의 다른 것들은 인증필요
            .authenticated()
        .and()
            .formLogin()
            .loginPage("/auth/loginForm");
    }
}
