package com.fruityveggies.www.web.recipes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruityveggies.www.dto.recipes.RecipeDto;
import com.fruityveggies.www.repository.recipes.Recipe;
import com.fruityveggies.www.service.recipes.RecipeService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/recipe")
public class RecipeController {
    
    private final RecipeService recipeService;
    
    @GetMapping("/detail")
    public String recipes(Model model) {
        log.info("recipes()");
        
        return "/recipe/detail"; // View의 이름.
    }
    
    @GetMapping("/upload")
    public String recipe(Model model) {
        log.info("upload()");
        
     // Get recipe list data from RecipeService
        List<Recipe> recipeList = recipeService.getRecipeList();
        // Add recipe list data to the Model
        model.addAttribute("recipeList", recipeList);
        
        return "/recipe/upload"; // View의 이름.
    }

    @PostMapping("/upload")
    public String create(RecipeDto dto) {
        log.info("upload(dto={}) POST", dto);
        
      //form에서 submit(제출)된 내용을 DB 테이블에 insert
        recipeService.create(dto);
        
     // DB 테이블 insert 후 레시피 목록 페이지로 redirect 이동.
        return "redirect:/main/recipes";
    }
    
}
