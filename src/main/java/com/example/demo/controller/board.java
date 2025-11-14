package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class board {

	@GetMapping("")
	public String board(Model model) {
		model.addAttribute("title", "📌 CRUD 게시판 📌");
		
		List<String> posts = Arrays.asList(
				"첫번째 글",
				"두번쨰 글",
				"세번쨰 글"
				);
		
		return "";// templates/board.html
	}
}
