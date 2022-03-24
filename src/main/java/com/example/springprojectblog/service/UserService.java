package com.example.springprojectblog.service;

import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해주미. IoC를 해준다.
//트랜젝션 관리
//서비스의 의미 여러개의 트랜젝션을 묶어서 하나의 트랜젝션으로 처리
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional(readOnly = true)
    public Users findUser(String username){
        Users users = userRepository.findByUsername(username).orElseGet(()->{
           return new Users();
        });
        return users;
    }



    @Transactional
    public void save(Users users) {

        String rawPassword = users.getPassword();//원래 비밀번호
        String endPassword = encoder.encode(rawPassword);//해쉬
        users.setRole(Role.USER);
        users.setPassword(endPassword);
        userRepository.save(users);


//        try {
//            return 1;//회원가입이 되었을때
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("UserService : save(): " + e.getMessage());
//            return -1; //회원가입이 실패 했을 때
//        }
    }

    @Transactional
    public void update(Users users) {
        // select해서 user 오브젝트를 DB로 부터 가져오는 이유는 영속화 하기 위해
        Users persistance = userRepository.findById(users.getId()).orElseThrow(() -> {
            return new IllegalArgumentException("아이디를 찾기 못했습니다.");
        });
//        Validate check
        if(persistance.getOauth()==null || persistance.getOauth().equals("")){
            String rawPassword = users.getPassword();
            String encPassword = encoder.encode(rawPassword);
            persistance.setPassword(encPassword);
            persistance.setEmail(users.getEmail());
        }



    }


/*
    @Transactional(readOnly = true)//select할 때 트랜젝션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
    public Users login(Users users){
        return userRepository.findByUsernameAndPassword(users.getUsername(), users.getPassword());

    }
*/

}
