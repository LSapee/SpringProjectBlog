package com.example.springprojectblog.repository;

import com.example.springprojectblog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//DAO
//자동으로 bean등록
//@Repository //생략 가능
public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);


}
//    로그인을 위한 함수
//    JPA네이밍 전략
//    Select * from users where username =? and password = ? ; 쿼리가 실행됨
//    Users findByUsernameAndPassword(String username, String password);

//    @Query(value = Select * from users where username =?1 and password = ?2" nativeQuery=true)
//    Users login(String username, String password);