package com.example.springprojectblog.service;

import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해주미. IoC를 해준다.
//트랜젝션 관리
//서비스의 의미 여러개의 트랜젝션을 묶어서 하나의 트랜젝션으로 처리
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(Users users) {
        userRepository.save(users);
//        try {
//            return 1;//회원가입이 되었을때
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("UserService : save(): " + e.getMessage());
//            return -1; //회원가입이 실패 했을 때
//        }
    }


/*
    @Transactional(readOnly = true)//select할 때 트랜젝션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
    public Users login(Users users){
        return userRepository.findByUsernameAndPassword(users.getUsername(), users.getPassword());

    }
*/

}
