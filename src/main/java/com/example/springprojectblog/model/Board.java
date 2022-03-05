package com.example.springprojectblog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String title;   //제목

    @Lob // 대용량 데이터를 사용할 때 쓰는 어노테이션
    private String content; // 게시글

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne // 연관관계 Many = board , One = User
    @JoinColumn(name="userId")
    private Users users; //JPA를 만들면 오브젝트를 저장 가능하다.

    @CreationTimestamp
    private Timestamp createDate;
}
