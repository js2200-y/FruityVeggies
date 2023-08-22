package com.fruityveggies.www.web;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruityveggies.www.dto.RescueOrderDto;
import com.fruityveggies.www.repository.rescue.RescueOrder;
import com.fruityveggies.www.service.RescueOrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RescueOrderController {

	private final RescueOrderService rescueOrderService;
   
   @PreAuthorize("hasRole('USER')")
   @GetMapping("/rescueorder/rescue_order")
   public String rescuorder() {
      
	   log.info("rescuorder get");
      return "/rescueorder/rescue_order";
   }
   
   @GetMapping("/rescueorder/rescue_order2")
   public String rescuorder2(Model model) {
      
	   log.info("read()");
	   
	   List<RescueOrder> list = rescueOrderService.read();
	   
	   model.addAttribute("rescues", list);
	   
	   
      return "/rescueorder/rescue_order2";
   }
   
   
   @PreAuthorize("hasRole('USER')")
   @PostMapping("/rescueorder/rescue_order")
   public String rescuorderPost(RescueOrderDto dto, @RequestParam String boxsize, @RequestParam List<String> dislikeList) {
	   log.info("create(dto={}) rescue", dto);
	   log.info("Received boxsize: {}", boxsize);
	   
	   dto.setBoxsize(boxsize); // 사용자 입력값을 dto에 설정
	    
	    if ("singlebox".equals(dto.getBoxsize())) {
	        dto.setBoxprice(15500);
	    } else {
	        dto.setBoxprice(25000);
	    }
	    
	    
	    if (dislikeList.size() >= 3) {
	        dto.setDislikeid1(dislikeList.get(0));
	        dto.setDislikeid2(dislikeList.get(1));
	        dto.setDislikeid3(dislikeList.get(2));
	    } 

	    
	   log.info("DTO after setting values: {}", dto);
	   
	   rescueOrderService.create(dto);
      
      return "/rescueorder/rescue_order2";
   }
   
   @PostMapping("/rescueorder/rescue_order2")
   public String rescuorder2Post( ) {
      
      log.info("rescuorder2 post={}");
      return "/rescueorder/rescue_order2";
   }
}