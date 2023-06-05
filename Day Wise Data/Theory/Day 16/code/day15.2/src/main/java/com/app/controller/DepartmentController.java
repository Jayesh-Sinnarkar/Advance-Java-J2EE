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
	// dep service layer i/f
	@Autowired
	private DepartmentService deptService;

	public DepartmentController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to get dept names from DB n share the B.L results
	// with the view layer
	@GetMapping("/show")
	public String getAllDeptNames(Model map) {
		System.out.println("in get all dept names " + map);
		map.addAttribute("dept_names",deptService.getDepartmentNames());
		return "/dept/depts";//AVN : /WEB-INF/views/dept/depts.jsp
	}
}
