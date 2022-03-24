package com.example.springprojectblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.sql.Timestamp;

@Data //getset
@Entity  //User 클래스를 읽어서 MySQL에 테이블이 생성된다.
@NoArgsConstructor  //빈 생성자
@AllArgsConstructor // 전체 생성자
@Builder //
//@DynamicInsert 더미데이터 알아서 제거
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // 시퀀스,auto_increment

//    not null 길이 20자까지
    @Column(nullable = false, length = 100,unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

// DB는 Role타입이라는게 없어서
    @Enumerated(EnumType.STRING)
    private Role role;


    private String oauth; // 로그인 구별

    // 시간이 자동으로 입력됨
    @CreationTimestamp
    private Timestamp createDate;
}
