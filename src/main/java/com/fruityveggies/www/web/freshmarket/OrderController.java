package com.fruityveggies.www.web.freshmarket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/freshmarketOrder")
    public String regularOrder() {
        
        log.info("regularOrder");
       return "order/freshmarketOrder";
    }
    
}
