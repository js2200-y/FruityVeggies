package com.fruityveggies.www.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Cart;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemOption;
import com.fruityveggies.www.service.ItemService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FreshMarketController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/freshmarket/cart")
    public String cart(Model model, @RequestParam(value = "id") String id) {
    	
    	log.info("cart get");
    	
    	List<Cart> lists = itemService.read(id);
    	
    	Item items = itemService.findItemById(lists.get(0).getItemid());
    	
    	log.info("lists={}"+lists);
    	
    	model.addAttribute("lists", lists);
    	model.addAttribute("imgUrl", items.getMain_image_path());
    	
    	return "/freshmarket/cart";
    }
    
	@GetMapping("/freshmarket/freshmarket")
	public String freshmarket(Model model, @RequestParam(value = "id") Long id, HttpSession session) {
		log.info("freshmarket(id={})",id);
	    
		session.setAttribute("returnPage", "/freshmarket/freshmarket?id=" + id);
		
		Item item = itemService.findItemById(id);
		log.info("item={}",item);
		model.addAttribute("item", item);
		
		// join시 가지고 올 값 (옵션 이름, 옵션 가격)
	    List<ItemItemOptionDto> items = itemService.getJoinedItemAndItemOptionByItemId(id);
	    
	    log.info("items={}",items);
	     model.addAttribute("items", items);
	    
		return "/freshmarket/freshmarket";
	}
	
	@PostMapping("/freshmarket/freshmarket")
	public String freshmarket(@RequestBody Map<String, Object> data) {
		
		log.info("freshmarket data={}",data);
//	
		List<String> names = (List<String>) data.get("names");
	    List<String> countsAsStrings = (List<String>) data.get("counts");
	    List<String> pricesAsStrings = (List<String>) data.get("prices");
	    String id = (String) data.get("id");
	    String userId = (String) data.get("userId");

	    List<Integer> counts = new ArrayList<>();
	    List<Integer> prices = new ArrayList<>();
	    
	    // counts와 prices를 String에서 Integer로 변환
	    for (String countStr : countsAsStrings) {
	        try {
	            counts.add(Integer.parseInt(countStr));
	        } catch (NumberFormatException e) {
	            // 처리할 예외 상황에 대한 로직 추가
	        }
	    }
	    for (String priceStr : pricesAsStrings) {
	        try {
	            prices.add(Integer.parseInt(priceStr));
	        } catch (NumberFormatException e) {
	            // 처리할 예외 상황에 대한 로직 추가
	        }
	    }
	    
	    // id를 Long으로 변환
	    Long convertedId = Long.parseLong(id);
	    
	    itemService.itemOrderSave(names, counts, prices, convertedId, userId);
	    
	    
		
		return "redirect:/main/mission";
	}
	
	@PostMapping("/freshmarket/cart")
	public String cart(@RequestBody Map<String, Object> data) {
		
		log.info("cart data={}",data);
//	
		List<String> names = (List<String>) data.get("names");
	    List<String> countsAsStrings = (List<String>) data.get("counts");
	    List<String> pricesAsStrings = (List<String>) data.get("prices");
	    String id = (String) data.get("id");
	    String userId = (String) data.get("userId");

	    List<Integer> counts = new ArrayList<>();
	    List<Integer> prices = new ArrayList<>();
	    
	    // counts와 prices를 String에서 Integer로 변환
	    for (String countStr : countsAsStrings) {
	        try {
	            counts.add(Integer.parseInt(countStr));
	        } catch (NumberFormatException e) {
	            // 처리할 예외 상황에 대한 로직 추가
	        }
	    }
	    for (String priceStr : pricesAsStrings) {
	        try {
	            prices.add(Integer.parseInt(priceStr));
	        } catch (NumberFormatException e) {
	            // 처리할 예외 상황에 대한 로직 추가
	        }
	    }
	    
	    // id를 Long으로 변환
	    Long convertedId = Long.parseLong(id);
	    
	    itemService.cartSave(names, counts, prices, convertedId, userId);
		
		return "redirect:/main/mission";
	}
}
