package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	//임시db
	private List<String> posts = new ArrayList<>();
	
	//게시판 보기
    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("title", "📌 CRUD 게시판 📌");
        model.addAttribute("posts", posts);
        return "board"; // templates/board.html
    }
    
    
    //게시판 등록
    @PostMapping("/board/write")
    public String writePost(@RequestParam("content") String content) {
    	posts.add(content);
    	return "redirect:/board";
    }
    
    
    
    
}
