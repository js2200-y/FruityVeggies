package com.fruityveggies.www.dto.recipes;



import com.fruityveggies.www.repository.recipes.Recipe;

import lombok.Data;

@Data
public class RecipeDto {

private Long id;
    
    private Long recipe_id;
    
    private String image;
    private String title;
    private String content;
    private String cooking_time;
    private String category_main;
    private String category_sub;
    private String hashtag;
    private String reference_amount;
    
    //DTO를 엔터티 객체로 변환해서 리턴하는 메서드
    public Recipe toEntity() {
        return Recipe.builder()
                .id(id)
                .recipe_id(recipe_id)
                .image(image)
                .title(title)
                .content(content)
                .cooking_time(cooking_time)
                .category_main(category_main)
                .category_sub(category_sub)
                .hashtag(hashtag)
                .reference_amount(reference_amount)
                .build();
    }
}
