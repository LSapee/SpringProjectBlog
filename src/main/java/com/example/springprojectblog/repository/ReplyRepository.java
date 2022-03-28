package com.example.springprojectblog.repository;

import com.example.springprojectblog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Reply(userid,boardid,content,createDate) VALUES(?1,?2,?3,now())",nativeQuery =true)
    int rSave(int userid, int boardid, String content); //업데이트된 행의 개수를 리턴해줌.


}
