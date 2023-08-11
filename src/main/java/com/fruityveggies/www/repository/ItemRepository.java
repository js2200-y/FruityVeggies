package com.fruityveggies.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
    @Query("SELECT a FROM Item a JOIN a.itemOption b WHERE a.itemOption = b")
    List<Item> findItemsWithItemOption(@Param("itemOption") ItemOption itemId);

    
}
