package com.example.springprojectblog.controller.api;

import com.example.springprojectblog.controller.config.auth.PrincipalDetail;
import com.example.springprojectblog.dto.ReplySaveRequestDto;
import com.example.springprojectblog.dto.ResponseDto;
import com.example.springprojectblog.model.Board;
import com.example.springprojectblog.model.Reply;
import com.example.springprojectblog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;
//글 등록
    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.save(board,principal.getUsers());
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
//글 삭제
    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        boardService.del(id);
        System.out.println(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
//   글 수정
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
        boardService.update(id,board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
//댓글 등록 (데이터 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.

    @PostMapping("/api/board/{boardid}/reply")
    public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto){

        boardService.saveReply(replySaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/api/board/{boardid}/reply/{replyid}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyid){
        boardService.replyDelete(replyid);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}