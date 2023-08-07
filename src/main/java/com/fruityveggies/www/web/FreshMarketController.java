package com.fruityveggies.www.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FreshMarketController {

	@GetMapping("/freshmarket/freshmarket")
	public String freshmarket() {
		
		return "/freshmarket/freshmarket";
	}
}
