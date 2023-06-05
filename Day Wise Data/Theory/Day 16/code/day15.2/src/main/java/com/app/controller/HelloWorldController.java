package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Mandatory cls level annotation to tell SC ,
//following is a spring bean containing req handling logic(=handler)
//singleton n eager
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("in ctor of " + getClass());
	}
	@RequestMapping("/hello") //equivalent to service of Servlet 
	//to tell SC , following is a req handling method 
	//which can accept -- get/post/put/delete/patch...
	public String sayHello()
	{
		System.out.println("in say hello");
		return "/display";//LVN (logical/forward view name) --> handler --> D.S
		//--> V.R ---> AVN : /WEB-INF/views/display.jsp
		//D.S : RD rd=request.getRD("/WEB-INF/views/display.jsp");
		//rd.forward(request,resp) --> view layer(JSP)
	}
	
}
