package com.fruityveggies.www.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @Autowired
    private ItemService itemService;
    
//    @PreAuthorize("hassRole('USER')") // 페이지 접근 이전에 인증(권한, 로그인) 여부를 확인.
    
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
        
        return "/main/regulardelivery"; // View의 이름.
    }
    
    @GetMapping("/main/market")
    public String market(Model model) {
        log.info("market()");
        
        
        List<Item> items = itemService.findByAll();
        log.info("item={}",items);
        model.addAttribute("items", items);
        
        
        List<ItemItemOptionDto> joinItems = itemService.getJoinAll();
        
        
        List<ItemItemOptionDto> uniqueItems = removeDuplicates(joinItems);
        
        
        log.info("uniqueItems={}",uniqueItems);
         model.addAttribute("uniqueItems", uniqueItems);
        
        return "/main/market"; // View의 이름.
    }
    
    public static List<ItemItemOptionDto> removeDuplicates(List<ItemItemOptionDto> items) {
        Map<Long, ItemItemOptionDto> uniqueItemsMap = new HashMap<>();
        for (ItemItemOptionDto item : items) {
            if (!uniqueItemsMap.containsKey(item.getId())) {
                uniqueItemsMap.put(item.getId(), item);
            }
        }
        return new ArrayList<>(uniqueItemsMap.values());
    }
    
    @GetMapping("/main/recipes")
    public String recipes(Model model) {
        log.info("recipes()");
        
        return "/main/recipes"; // View의 이름.
    }

}
