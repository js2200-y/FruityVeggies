package com.fruityveggies.www.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fruityveggies.www.repository.review.Review;
import com.fruityveggies.www.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
//    @PreAuthorize("hassRole('USER')") // 페이지 접근 이전에 인증(권한, 로그인) 여부를 확인.
    
    @Autowired
    private ReviewService reviewService;
    
    @GetMapping("/")
    public String home(Model model) {
        log.info("home()");
        
        return "/main/index"; // View의 이름.
    }
    
    @GetMapping("/main/mission")
    public String mission(Model model) {
        log.info("mission()");
        
        return "/main/mission"; // View의 이름.x
    }
    
    @GetMapping("/main/regulardelivery")
    public String regulardelivery(Model model) {
        log.info("regulardelivery()");
        
        List<Review> lists = reviewService.findByAll();
        
        log.info("lists={}",lists);
        
        model.addAttribute("lists", lists);
        
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
