package com.fruityveggies.www.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RescueStoreController {

	
	@GetMapping("/fvstore/freshmarket")
	public String freshmarket() {
		
		return "/fvstore/freshmarket";
	}
}
