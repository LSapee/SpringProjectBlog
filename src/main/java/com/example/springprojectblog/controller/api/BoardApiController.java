package com.example.springprojectblog.controller.api;

import com.example.springprojectblog.controller.config.auth.PrincipalDetail;
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

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.save(board,principal.getUsers());
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        boardService.del(id);
        System.out.println(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
        boardService.update(id,board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PostMapping("/api/board/{id}/reply")
    public ResponseDto<Integer> replySave(@PathVariable int boardid,@RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.saveReply(principal.getUsers(),boardid,reply);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}