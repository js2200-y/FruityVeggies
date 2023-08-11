package com.fruityveggies.www.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemOption;
import com.fruityveggies.www.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/freshmarket")
public class FreshMarketController {

    private final ItemService itemService;
    
//	@GetMapping("/freshmarket/freshmarket")
//	public String freshmarket() {
//		
//		return "/freshmarket/freshmarket";
//	}
	
	@GetMapping("/all/{itemId}")
    public ResponseEntity<List<Item>> getItemsWithOption(@PathVariable long itemId) {
        log.info("getItemsWithOption(optionId={})", itemId);


        List<Item> items = itemService.getItemsWithItemOption(itemId);
        return ResponseEntity.ok(items);
    }

	    
	    
	    
	}

