package com.example.springprojectblog.controller;

import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

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

    @GetMapping("/dummy/users/{id}")
    public Users detail(@PathVariable int id){
//      get = null일리가 없어.
//      orElseGet = 빈객체로 넣기
/*        Users users = userRepository.findById(id).orElseGet(new Supplier<Users>() {
            @Override
            public Users get() {
                return new Users();
            }
        });*/
//      람다식
        /*
        Users users = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 사용자는 없습니다.");
            });
        */
        Users users = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : " + id );
            }
        });
//      요청 : 웹 브라우저
//      users 객체 = 자바 오브젝트
//      변환 ->Json
//      스프링부트가 자바 오브젝트를 알아서 json으로 변환해서 브라우저에게 줌
        return users;
    }
}
