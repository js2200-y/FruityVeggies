package com.fruityveggies.www.web;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Cart;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.service.ItemService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    
    
//	@GetMapping("/freshmarket/freshmarket")
//	public String freshmarket() {
//		
//		return "/freshmarket/freshmarket";
//	}
	    
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
