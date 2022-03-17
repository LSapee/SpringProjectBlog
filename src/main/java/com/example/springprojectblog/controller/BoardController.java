package com.example.springprojectblog.controller;


import com.example.springprojectblog.controller.config.auth.PrincipalDetail;
import com.example.springprojectblog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping({"","/"})
    public String index(Model model){
        model.addAttribute("boards",boardService.boardAll());
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveFrom(){

        return "board/saveForm";
    }
}
