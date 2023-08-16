package com.fruityveggies.www.repository.recipes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasoningRepository extends JpaRepository<Seasoning, Long> {

    //recipe로 검색
    List<Seasoning> findByRecipeOrderById(Recipe recipe);
}
