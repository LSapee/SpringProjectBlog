package com.example.springprojectblog.controller;


import com.example.springprojectblog.controller.config.auth.PrincipalDetail;
import com.example.springprojectblog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping({"","/"})
    public String index(Model model, @PageableDefault(size=2, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boards",boardService.boardAll(pageable));
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveFrom(){

        return "board/saveForm";
    }
    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model){

        model.addAttribute("board",boardService.boardVD(id));
        return "board/detail";
    }

    @GetMapping("board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("board",boardService.boardVD(id));
        return "board/updateForm";
    }
}
