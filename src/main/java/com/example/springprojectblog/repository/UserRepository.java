package com.example.springprojectblog.repository;

import com.example.springprojectblog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
//자동으로 bean등록
//@Repository //생략 가능
public interface UserRepository extends JpaRepository<Users, Integer> {

    
}
