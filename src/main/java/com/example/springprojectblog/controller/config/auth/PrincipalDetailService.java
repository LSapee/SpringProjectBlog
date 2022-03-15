package com.example.springprojectblog.controller.config.auth;

import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    스프링이 로그인 요청을 가로챌 때 , username,password 변수 2개
//    password 부분 처리는 알아서 함.
//    username이 DB에 있는지만 확인해주면 된다.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
            return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
        });
        return new PrincipalDetail(principal); //시큐리티의 세션에 유저정보가 저장이 됨
    }
}
