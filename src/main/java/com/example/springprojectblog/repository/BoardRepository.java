package com.example.springprojectblog.repository;

import com.example.springprojectblog.model.Board;
import com.example.springprojectblog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {


}
