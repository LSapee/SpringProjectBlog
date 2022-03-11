package com.example.springprojectblog.controller.api;

import com.example.springprojectblog.dto.ResponseDto;
import com.example.springprojectblog.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody Users users){
        System.out.println("save 호출");
//        실제로 DB에 insert를 하고 아래에서 리턴
        return new ResponseDto<Integer>(HttpStatus.OK,1);
    }
}
