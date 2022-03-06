package com.example.springprojectblog.controller;

import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

//    http://localhost:8000/blog/dummy/join
//    http의 body에 username,password,email 데이터를 가지고 요청
    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(Users users){
        System.out.println(users.getId());
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        System.out.println(users.getEmail());

        users.setRole(Role.USER);
        userRepository.save(users);
        return "회원가입이 완료되었습니다.";
    }
}
