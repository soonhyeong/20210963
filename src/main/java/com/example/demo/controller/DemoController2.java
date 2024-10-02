package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 어노테이션 명시
public class DemoController2 {
    @GetMapping("/hello2") // 전송 방식 GET
    public String hello(Model model) {
        model.addAttribute("data", " 권순형님."); // model 설정
        model.addAttribute("data2", " 방갑습니다.");
        model.addAttribute("data3", " 오늘.");
        model.addAttribute("data4", " 날씨는.");
        model.addAttribute("data5", " 매우 좋습니다.");
        return "hello2"; // hello.html 연결
    }
}

