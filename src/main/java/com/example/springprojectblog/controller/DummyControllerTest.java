package com.example.springprojectblog.controller;

import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

//    http://localhost:8000/blog/dummy/join
//    http의 body에 username,password,email 데이터를 가지고 요청
    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

//    select
    @GetMapping("/dummy/users")
    public List<Users> list(){
        return userRepository.findAll();
    }


//    sava함수는 id를 전달하지 않으면 insert를 해주고
//    save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update해주고
//    save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 한다.
   @Transactional
   @PutMapping("/dummy/users/{id}")
    public Users updateUser(@PathVariable int id,@RequestBody Users requestUsers){

        System.out.println(requestUsers.getPassword());
        System.out.println(requestUsers.getEmail());
        requestUsers.setId(id);
        Users users = userRepository.getById(id);

        users.setPassword(requestUsers.getPassword());
        users.setEmail(requestUsers.getEmail());

        //더티체킹 ->

        return users;
    }



    @GetMapping("/dummy/users/page")
    public List<Users> pageList(@PageableDefault(size=2,sort="id",direction= Sort.Direction.DESC) Pageable pageable){
        Page<Users> pagingUsers = userRepository.findAll(pageable);

        List<Users> users = pagingUsers.getContent();
        return users;
    }

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

//    JPA 영속성 컨텍스터
//    1차캐시 ->  flush
//    DB에서 데이터를 가져와서 영속화
//    @Transaction 메소드 종료될 때 종료 함수 종료시 자동 commit

    @DeleteMapping("/dummy/users/{id}")
    public String UserDelete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "아이디가 없습니다.";
        }
        return "아이디가 삭제되었습니다.";
    }
}
