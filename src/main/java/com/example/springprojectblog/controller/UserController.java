package com.example.springprojectblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm(){

        return "/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){

        return "/loginForm";
    }

    @PostMapping
    public String join(){
        return "aaa";
    }
}
