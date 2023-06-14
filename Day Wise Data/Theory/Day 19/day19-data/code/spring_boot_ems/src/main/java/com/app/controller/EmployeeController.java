package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.service.AddressService;
import com.app.service.DepartmentService;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@Autowired
	private AddressService adrService;

	@Autowired
	private DepartmentService deptService;

	@GetMapping("/list")
	//Long chosenDept=Long.parseLong(request.getParamter("chosenDept"));
	public String getEmpsByDepartment(@RequestParam Long chosenDept,
			Model map, HttpSession session) {
		System.out.println("in get emps by dept " + chosenDept);
		// get chosen dept details n add it under sesison scope
		session.setAttribute("selected_dept", deptService.getDepartmentDetails(chosenDept));
		map.addAttribute("emp_list", empService.getAllEmployeesFromDept(chosenDept));
		return "/emp/list";//AVN : /WEB-INF/views/emp/list.jsp
	}

	// http://localhost:8080/ems/emp/show_adr?id=1
	// add a method to display address
	@GetMapping("/show_adr")
	public String getEmpAddress(@RequestParam long id, Model map) {
		System.out.println("in get emp adr " + id);
		try {
			map.addAttribute("emp_adr", adrService.getAddressDetails(id));
		} catch (RuntimeException e) {
			System.out.println(e);
			map.addAttribute("emp_adr", "Address not yet assigned!");
		}
		return "/emp/show_adr";

	}
	//  http://localhost:8080/ems/emp/delete/1
	//URI template var / path var.
	@GetMapping("/delete/{empId}")
	public String deleteEmpDetails(@PathVariable  long empId,
			RedirectAttributes flashMap,HttpSession session)
	{
		System.out.println("in del emp details "+empId);
		flashMap.addFlashAttribute("status", empService.deleteEmpDetails(empId));
		long deptId=((Department)session.getAttribute("selected_dept")).getId();
		return "redirect:/emp/list?chosenDept="+deptId;
		//SC : resp.sendRedirect(resp.encodeRedirectURL("emp/list"));
	}
	// http://localhost:8080/ems/emp/add
	@GetMapping("/add")
	public String showAddEmpDetailsForm(Employee emp)
	{
		System.out.println("add emp form "+emp);		
		return "/emp/add";
	}
	// http://localhost:8080/ems/emp/add , method=POST
		@PostMapping("/add")
		public String processAddEmpDetailsForm(Employee emp,HttpSession session,RedirectAttributes flashMap)
		{
			System.out.println("process add emp "+emp);
			long deptId=((Department)session.getAttribute("selected_dept")).getId();
			flashMap.addFlashAttribute("status",empService.addNewEmployee(deptId,emp));
			return "redirect:/emp/list?chosenDept="+deptId;
		}
	
	
}
