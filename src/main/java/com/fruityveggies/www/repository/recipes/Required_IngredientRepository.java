package com.fruityveggies.www.repository.recipes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface Required_IngredientRepository  extends JpaRepository<Required_Ingredient, Long> {

    //recipe로 검색하기:
    List<Required_IngredientRepository> findByRecipeOrderById(Recipe recipe);

    

    
}
