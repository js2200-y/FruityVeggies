package com.fruityveggies.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
	
    /**
     * 로그인 페이지
     * @return
     */
    @GetMapping("/login")
    public String login(Model model) {
        log.info("login()");
        return "/login/login";
    }
    @PostMapping("/login")
    public String loginPost(Model model) {
        log.info("loginPost()");
        return "redirect:/login/login"; // 로그인 후 리다이렉트할 페이지 설정
    }
    
    @GetMapping("/login/mypage")
    public String myPage(Model model) {
        log.info("myPage()");
        return "/login/mypage";
    }
    @GetMapping("/login/orderhistory")
    public String orderhistory(Model model) {
        log.info("orderhistory");
        return "/login/orderhistory";
    }
}


    /**
     * 메인 페이지
     * @return
     */
    /*
     * @GetMapping("/") public String main() { log.info("main"); return
     * "/main/main"; }
     */
    
