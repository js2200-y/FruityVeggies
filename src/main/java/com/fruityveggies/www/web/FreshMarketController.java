package com.fruityveggies.www.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FreshMarketController {
    
    @Autowired
    private ItemService itemService;
    
//	@GetMapping("/freshmarket/freshmarket")
//	public String freshmarket() {
//		
//		return "/freshmarket/freshmarket";
//	}
	    
	@GetMapping("/freshmarket/freshmarket")
	public String freshmarket(Model model, @RequestParam(value = "id") Long id) {
		log.info("freshmarket(id={})",id);
	    
		Item item = itemService.findItemById(id);
		log.info("item={}",item);
		model.addAttribute("item", item);
		
		// join시 가지고 올 값 (옵션 이름, 옵션 가격)
	    List<ItemItemOptionDto> items = itemService.getJoinedItemAndItemOptionByItemId(id);
	    
	    log.info("items={}",items);
	     model.addAttribute("items", items);
	    
	    // 상품이름 : 스트링
	    // 성장 특징 :
	    // 메인 이미지
	    // 디테일 이미지
	 // 옵션 이름 : 배열
        // 옵션 가격 : 배열
//	    String name = items.get(0).getName();
//	    log.info("name={}", name);
//	    model.addAttribute("name", name);
//	    String growChar = items.get(0).getGrow_char();
//	    log.info("growChar={}", growChar);
//        model.addAttribute("growChar", growChar);       
//	    String mainImg = items.get(0).getMain_image_path();
//	    String detailImg = items.get(0).getDetail_image_path();
//	    log.info("mainImg={}", mainImg);
//        model.addAttribute("mainImg", mainImg);
//        log.info("detailImg={}", detailImg);
//        model.addAttribute("detailImg", detailImg);
//	    List<String> itemOptNames = new ArrayList<>(); 
//	    List<Integer> itemOptPrices = new ArrayList<>();
	    
//	    log.info("options={}", items);
//	    for(int i=0;i<items.size();i++) {
//	        itemOptNames.add(items.get(i).toString());
//	    }
	    
//	    log.info("itemOptNames:"+itemOptNames);
//	    log.info("itemOptPrices:"+itemOptPrices);
//	    
//	    for(int i=0; i<items.size();i++) {
//	        itemOptNames.add(i, items.get(i).getItemOption().getName()) ;
//	        itemOptPrices.add (i, items.get(i).getItemOption().getPrice());	       
//	    }
	    
//	    log.info("itemOptNames={}", itemOptNames);
//        model.addAttribute("itemOptNames", itemOptNames);
//        log.info("itemOptPrices={}", itemOptPrices);
//        model.addAttribute("itemOptPrices", itemOptPrices);
        
//	    log.info("items={}", items);
//	    log.info("name={}", name);
//	    log.info("growChar={}", growChar);
//	    log.info("mainImg={}", mainImg);
//	    log.info("detailImg={}", detailImg);
//	    log.info("itemOptNames={}", itemOptNames);
//	    log.info("itemOptPrices={}", itemOptPrices);
//	    
//	    
//	    
//	    

//	    model.addAttribute("name", name);
//	    model.addAttribute("growChar", growChar);
//	    model.addAttribute("mainImg", mainImg);
//	    model.addAttribute("detailImg", detailImg);
//	    model.addAttribute("itemOptNames", itemOptNames);
//	    model.addAttribute("itemOptPrices", itemOptPrices);
	    
	    
		return "/freshmarket/freshmarket";
	}
}
