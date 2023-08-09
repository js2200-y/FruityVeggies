package com.fruityveggies.www.web.recipes;

import java.time.LocalDateTime;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {
    
    @GetMapping("/detail")
    public String recipes(Model model) {
        log.info("recipes()");
        
        return "/recipe/detail"; // View의 이름.
    }
    
    @GetMapping("/upload")
    public String recipe(Model model) {
        log.info("upload()");
        
        return "/recipe/upload"; // View의 이름.
    }

}
