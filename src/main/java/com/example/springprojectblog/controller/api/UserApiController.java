package com.example.springprojectblog.controller.api;

import com.example.springprojectblog.dto.ResponseDto;
import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody Users users){
        System.out.println("save 호출");
//        실제로 DB에 insert를 하고 아래에서 리턴
        users.setRole(Role.USER);
        userService.save(users);
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
