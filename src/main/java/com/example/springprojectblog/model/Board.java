package com.example.springprojectblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String title;   //제목

    @Lob // 대용량 데이터를 사용할 때 쓰는 어노테이션
    private String content; // 게시글

    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // 연관관계 Many = board , One = User
    @JoinColumn(name="userId")
    private Users users; //JPA를 만들면 오브젝트를 저장 가능하다.

    @OneToMany(mappedBy = "board",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다. (fK가 아니다) %FK는 Reply.board이다.
    @JsonIgnoreProperties({"board"}) //무한참조 방지
    @OrderBy("id desc")
    private List<Reply> replys;

    @CreationTimestamp
    private Timestamp createDate;
}
