package com.example.springprojectblog.service;

import com.example.springprojectblog.model.Board;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void save(Board board, Users users) {
        board.setCount(3);
        board.setUsers(users);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> boardAll(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board boardVD(int id){
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패");
                });
    }

    @Transactional
    public void del(int id){
        System.out.println(id);
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(int id,Board requestBoard){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new  IllegalArgumentException("글 수정 실패");
                }); //영속화 완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //해당 함수로 종료시 service가 종료될 때 트랜젝션이 종료됩니다.
    }
}
