package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	// dep : service layer i/f
	@Autowired
	private DepartmentService deptService;

	public DepartmentController() {
		System.out.println("in ctor of " + getClass());
	}
	//add req handling method to get all dept names
	@GetMapping("/show")
	public String showDeptNames(Model map)
	{
		//invoke service layer
		map.addAttribute("depts", deptService.getAllDepartmentNames());
		return "/dept/show";//AVN : /WEB-INF/views/dept/show.jsp
	}
}
