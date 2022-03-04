package com.example.springprojectblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

//    http://localhost:8000/blog/temp/home
    @GetMapping("/temp/home")
    public String tempHome(){
        // 파일리턴 기본경로 :src/main/resources/static
        //return "home.html";을 못 찾는 이유는  src/main/resources/statichome.html 로 뒤로 바로 붙기 떄문에 /를 붙여줘야한다
        //static에는 정적 파일만 넣는다
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempIMG(){
        return "/a.png";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp(){
        return "Test";
    }
}
