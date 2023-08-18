package com.fruityveggies.www.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
   
   @PostMapping("/rescueorder/rescue_order")
   public String rescuorderPost(RescueOrderDto dto) {
	   log.info("create(dto={}) rescue", dto);
	   
	   rescueOrderService.create(dto);
      
      return "/rescueorder/rescue_order2";
   }
   
   @PostMapping("/rescueorder/rescue_order2")
   public String rescuorder2Post( ) {
      
      log.info("rescuorder2 post={}");
      return "/rescueorder/rescue_order2";
   }
}