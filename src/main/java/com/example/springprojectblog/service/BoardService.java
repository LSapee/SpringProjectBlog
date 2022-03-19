package com.example.springprojectblog.service;

import com.example.springprojectblog.model.Board;
import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.BoardRepository;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
        boardRepository.deleteById(id);
    }
}
