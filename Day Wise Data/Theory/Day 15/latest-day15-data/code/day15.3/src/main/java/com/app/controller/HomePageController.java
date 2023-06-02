package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of "+getClass());
	}
	@RequestMapping("/")
	public String showHomePage(Model map) {
		System.out.println("in show hm page");
		map.addAttribute("server_ts",LocalDateTime.now());
		return "/index";	//AVN : /WEB-INF/views/index.jsp	
	}
	
}
