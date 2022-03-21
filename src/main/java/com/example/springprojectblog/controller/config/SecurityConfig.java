package com.example.springprojectblog.controller.config;

import com.example.springprojectblog.controller.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것
@Configuration  //빈 등록
@EnableWebSecurity      //필터링 권한 
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean
    public BCryptPasswordEncoder encoderPWD() {
        return new BCryptPasswordEncoder();
    }
/*
시큐리티가 대신 로그인 해줄 때 password를 가로채기를 하는데
해당 password가 어떤 해쉬로 되어 회원가입이 되었는지 알아야
같은 해쉬로 암호화해서 DB에 있는 해쉬랄 비교할 수 있다.
*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(principalDetailService).passwordEncoder(encoderPWD());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()//csrf 토큰 비활성화
            .authorizeRequests()
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/img/**")//권한 허용 /auth는 누구나 가능
                .permitAll()
                .anyRequest()//이외의 다른 것들은 인증필요
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/auth/loginForm")
                .loginProcessingUrl("/auth/loginProc")// 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
                .defaultSuccessUrl("/"); // 로그인 되면 "/"로 이동

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
