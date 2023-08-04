package com.fruityveggies.www.web;

import java.time.LocalDateTime;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
//    @PreAuthorize("hasRole('USER')") // 페이지 접근 이전에 인증(권한, 로그인) 여부를 확인.
    @GetMapping("/")
    public String home(Model model) {
        log.info("home()");
        
        return "/main/index"; // View의 이름.
    }
    
    @GetMapping("/main/regulardelivery")
    public String regulardelivery(Model model) {
        log.info("regulardelivery()");
        
        return "/main/regulardelivery"; // View의 이름.
    }
    
    @GetMapping("/main/market")
    public String market(Model model) {
        log.info("market()");
        
        return "/main/market"; // View의 이름.
    }
    
    @GetMapping("/main/recipes")
    public String recipes(Model model) {
        log.info("recipes()");
        
        return "/main/recipes"; // View의 이름.
    }

}
