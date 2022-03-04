package com.example.springprojectblog.controller;


import com.example.springprojectblog.Member;
import org.springframework.web.bind.annotation.*;

//사용자가 요청 -> 응답(Data)

@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest(){
//      Member m = new Member(1,"asd","dsa","email");
//      builder 사용시
//      내가 원하는 것만 가져오기
//      builder 추가 장점 순서대로 작성에서 실수가 생길 것을 예방한다.
        Member m = Member.builder().password("1234").email("dsa@dsa.com").username("asda").build();
        System.out.println(TAG+"getter : " +m.getId());
        m.setId(5000);
        System.out.println(TAG+"getter : " +m.getId());
        return "lombok test 완료";
    }

//    인터넷 브라우저 요청은 무조껀 get 요청밖에 할 수 없다.
    @GetMapping("/http/get")
// get 방식으로 요청 - 쿼리스트링
    public String getTest(Member m) {
        System.out.println(TAG + "");

        return "get 요청" + m.getId() + m.getUsername() + m.getPassword() + m.getEmail();
    }

    @PostMapping("/http/post")
//    x-www-form-urlincoded 방식
//    json 방식
//    raw data = text/plain

    public String postTest(@RequestBody Member m) {
        return "post 요청" + ": " + m.getId() + m.getUsername() + m.getPassword() + m.getEmail();

    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청 : "+ m.getId() + m.getUsername() + m.getPassword() + m.getEmail();

    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";

    }

}
