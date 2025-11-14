package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestBoardController {

	@GetMapping("/testboard")
	public String testboard(Model model) {
		
		model.addAttribute("title", "📋 게시판 📋");
		model.addAttribute("content", "게시판 내용 (+컨트롤러로 추가)");
		
		return "testboard";
	}

}
