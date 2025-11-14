package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.RealBoard;
import com.example.demo.repository.RealBoardRepository;

@Controller
public class RealBoardController {

    @Autowired
    private RealBoardRepository realboardRepository;

    // 게시판 보기
    @GetMapping("/realboard")
    public String board(Model model) {
        model.addAttribute("title", "📌 CRUD 게시판 📌");
        model.addAttribute("posts", realboardRepository.findAll()); // DB에서 모든 글 조회
        return "realboard"; // templates/realboard.html
    }

    // 게시글 등록
    @PostMapping("/realboard/write")
    public String writePost(@RequestParam("content") String content) {
        realboardRepository.save(new RealBoard(content)); // DB에 저장
        return "redirect:/realboard"; // 등록 후 다시 게시판으로 이동
    }

    // 게시글 삭제
    @GetMapping("/realboard/delete")
    public String deletePost(@RequestParam("id") Long id) {
        realboardRepository.deleteById(id); // 해당 ID 글 삭제
        return "redirect:/realboard"; // 삭제 후 게시판으로 이동
    }

    // 게시글 수정 페이지 이동
    @GetMapping("/realboard/edit")
    public String editPost(@RequestParam("id") Long id, Model model) {
        RealBoard post = realboardRepository.findById(id).orElse(null);
        if (post == null) {
            return "redirect:/realboard"; // 글이 없으면 게시판으로 이동
        }
        model.addAttribute("post", post);
        return "edit_realboard"; // templates/edit_realboard.html
    }

    // 게시글 수정 처리
    @PostMapping("/realboard/update")
    public String updatePost(@RequestParam("id") Long id,
                             @RequestParam("content") String content) {
        RealBoard post = realboardRepository.findById(id).orElse(null);
        if (post != null) {
            post.setContent(content);
            realboardRepository.save(post); // 수정 후 저장
        }
        return "redirect:/realboard"; // 수정 후 게시판으로 이동
    }
}

