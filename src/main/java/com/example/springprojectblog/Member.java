package com.example.springprojectblog;

import lombok.*;

@Data //Getter + Setter
@NoArgsConstructor // 빈 생성자
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