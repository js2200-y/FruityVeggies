package com.fruityveggies.www.web.recipes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruityveggies.www.dto.recipes.AdditionalIngredientDto;
import com.fruityveggies.www.dto.recipes.RecipeDto;
import com.fruityveggies.www.dto.recipes.RecipeUploadDto;
import com.fruityveggies.www.dto.recipes.Required_IngredientDto;
import com.fruityveggies.www.dto.recipes.SeasoningDto;
import com.fruityveggies.www.repository.recipes.Recipe;
import com.fruityveggies.www.service.recipes.AdditionalIngredientService;
import com.fruityveggies.www.service.recipes.RecipeService;
import com.fruityveggies.www.service.recipes.Required_IngredientService;
import com.fruityveggies.www.service.recipes.SeasoningService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/recipe")
public class RecipeController {
    
    private final RecipeService recipeService;
    private final Required_IngredientService required_IngredientService;
    private final AdditionalIngredientService additionalIngredientService;
    private final SeasoningService seasoningService;
    
    
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
    public String create(RecipeUploadDto dto) {
        log.info("upload(dto={}) POST", dto);
        
      //form에서 submit(제출)된 내용을 DB 테이블에 insert
        RecipeDto recipeDto = dto.toRecipeDto();
        log.info("recipeDto = {}", recipeDto);
        Recipe recipe = recipeService.create(recipeDto);
        log.info("recipe id = {}", recipe.getId());
        
        //필수재료 리스트 넘기는
        List<Required_IngredientDto> reqIngredList = 
                dto.toRequiredIngredientList(recipe.getId());
        for (Required_IngredientDto reqIngred : reqIngredList) {
            required_IngredientService.create(reqIngred);
        }
        
        //부재료 리스트 넘기는
        List<AdditionalIngredientDto> addIngreList =
                dto.toAdditionalIngredientList(recipe.getId());
        for(AdditionalIngredientDto addIngred : addIngreList) {
            additionalIngredientService.create(addIngred);
        }
        
        //양념 리스트 넘기는
        List<SeasoningDto> seasoningList = 
                dto.toSeasoningList(recipe.getId());
        for(SeasoningDto seasoning : seasoningList) {
            seasoningService.create(seasoning);
        }
        
     // DB 테이블 insert 후 레시피 목록 페이지로 redirect 이동.
        return "redirect:/main/recipes";
    }
    
}
