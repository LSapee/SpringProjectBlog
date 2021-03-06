package com.example.springprojectblog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/**
//그냥 주소가 / 이면 index.jsp 허용
//

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){

        return "/user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){

        return "/user/loginForm";
    }

    @GetMapping("/user/updateform")
    public String updateForm(@AuthenticationPrincipal Principal principal){
        return "/user/updateform";
    }


}
