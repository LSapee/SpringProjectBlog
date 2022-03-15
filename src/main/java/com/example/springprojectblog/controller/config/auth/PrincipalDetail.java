package com.example.springprojectblog.controller.config.auth;

import com.example.springprojectblog.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/*
springsecurity가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 userDetails 타입의 오브젝트를
스프링 시큐리티의 고유한 세션저장소에 저장하는데 그것이 PrincipalDetail
*/
public class PrincipalDetail implements UserDetails {

    private Users users;//콤포지션

    public PrincipalDetail(Users users){
        this.users = users;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }


//    계정이 만료되지 않았는지 리턴한다.
    @Override
    public boolean isAccountNonExpired() {
        return true;// 만료 아님
    }
//계정 잠김
    @Override
    public boolean isAccountNonLocked() {
        return true;//안 잠김
    }
//비밀번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
//계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
//    계정의 권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //
        Collection<GrantedAuthority> collectors = new ArrayList<>();
/*        collectors.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                 //ROLE_USER
                return "ROLE_"+users.getRole();
            }
        });*/
        collectors.add(()->{return "ROLE_"+users.getRole();});
        return collectors;
    }
}
