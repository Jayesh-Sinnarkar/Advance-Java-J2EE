package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}

	// add a req handling method to ret result(server Ts) to D.S
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test m n v");
		return new ModelAndView("/test/test1", "server_ts",
				LocalDateTime.now());//AVN : /WEB-INF/views/test/test1.jsp
		/*
		 * R.H.C(handler) -->MnV --> D.S D.S --> LVN --> V.R --> AVN D.S chks for model
		 * attrs --->1 model attr --> D.S saves model attrs under req scope
		 * D.S --> forwards  --> view 
		 */
	}
	//add req handing method for testing model map
	@GetMapping("/test2")
	public String testModelMap(Model modelMap)
	{
		System.out.println("in test model map "+modelMap);//{}
		modelMap.addAttribute("server_ts", LocalDateTime.now())
		.addAttribute("number_list", Arrays.asList(10,20,30,40));
		System.out.println("in test model map "+modelMap);//{2}
		return "/test/test2";
		/*
		 * Handler ---> LVN (explicilty) --> D.S
		 * implicitly --model map --> D.S
		 * D.S --> LVN --> V.R --> AVN : /WEB-INF/views/test/test2.jsp
		 * D.S --> adds model attrs under req scope --> forwards to view layer
		 */
	}
}
