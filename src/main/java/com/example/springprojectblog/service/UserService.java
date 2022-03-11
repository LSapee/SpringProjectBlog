package com.example.springprojectblog.service;

import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해주미. IoC를 해준다.
//트랜젝션 관리
//서비스의 의미 여러개의 트랜젝션을 묶어서 하나의 트랜젝션으로 처리
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int save(Users users) {
        try {
            userRepository.save(users);
            return 1;//회원가입이 되었을때
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService : save(): " + e.getMessage());
            return -1; //회원가입이 실패 했을 때
        }

    }
}
