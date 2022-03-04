package com.example.springprojectblog;

import lombok.*;

//@Getter
//@Setter
@Data //Getter + Setter
//@AllArgsConstructor // 전체 생성자
@NoArgsConstructor // 빈 생성자
//@RequiredArgsConstructor // final 붙은 애들에 대한 Constructor이 붙음
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
/*  builder가 없으면 생성자를 하나 더 만들어서 처리해야함
    public Member( String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
*/

}