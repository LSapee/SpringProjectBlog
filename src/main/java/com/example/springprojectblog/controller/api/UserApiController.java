package com.example.springprojectblog.controller.api;

import com.example.springprojectblog.dto.ResponseDto;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody Users users){
        System.out.println("save 호출");
//        실제로 DB에 insert를 하고 아래에서 리턴

        userService.save(users);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody Users users){
        userService.update(users);
//        세션값은 변경되지 않은 상태, DB값은 변경되어있음.
//        세션을 우리가 직접 변경하기
        //        세션 등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);

    }



/*  스프링 시큐리티 사용시 다른 방식으로 로그인을 함
    @Autowired
    private HttpSession session;

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody Users users){
        Users principal = userService.login(users);
        if(principal != null){
            session.setAttribute("principal",principal );
        }

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
    */

}
