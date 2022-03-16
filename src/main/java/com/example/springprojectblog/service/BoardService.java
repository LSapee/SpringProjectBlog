package com.example.springprojectblog.service;

import com.example.springprojectblog.model.Board;
import com.example.springprojectblog.model.Role;
import com.example.springprojectblog.model.Users;
import com.example.springprojectblog.repository.BoardRepository;
import com.example.springprojectblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
