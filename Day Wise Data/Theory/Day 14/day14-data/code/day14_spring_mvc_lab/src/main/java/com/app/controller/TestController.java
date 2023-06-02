package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}
	@GetMapping("/test1") //can intercept only GET method
	public String generateDynResp(Model map)
	{
		System.out.println("in gen dyn resp "+map);//{}
		map.addAttribute("server_ts", LocalDateTime.now());
		System.out.println(map);//{server_ts : .....}
		return "/test/test1";//AVN : /WEB-INF/views/test/test1.jsp
	}
}
