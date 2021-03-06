package com.example.springprojectblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class SpringProjectBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectBlogApplication.class, args);
    }
    
    
//    혹시 8080포트 실행중이라고 메시지가 나오지만 cmd 에서 pid 8080 포트가 안보일떄 해결방안 찾아보기 컴퓨터 재부팅 이외의
//stateful 연결이 지속되어있는 통신
//http는 stateless 방식임
}