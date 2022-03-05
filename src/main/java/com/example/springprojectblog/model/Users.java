package com.example.springprojectblog.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Timestamp;

@Data
@Entity  //User 클래스를 읽어서 MySQL에 테이블이 생성된다.
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // 시퀀스,auto_increment

//    not null 길이 20자까지
    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //Enum을 쓰는게 좋다.
    @ColumnDefault("'user'")
    private String role;

    // 시간이 자동으로 입력됨
    @CreationTimestamp
    private Timestamp createDate;
}
