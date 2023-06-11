package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@RestController // =@Controller : cls level + @ResponseBody : ret type of the req handling
				// methods : @RequestMapping / @GetMapping....
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	// dep
	@Autowired
	private EmployeeService empService;

	public EmployeeController() {
		System.out.println("in def ctor of " + getClass());
	}

	// http://host:port/employees , method=GET
	@GetMapping
	// SC adds @ResponseBody : on ret type
	public List<Employee> fetchAllEmps() {
		System.out.println("in fetch all emps");
		return empService.getAllEmps();
	}
	/*
	 * handler -->@ResponseBody List<Emp>--> D.S SC uses Jackson jars to perform
	 * --ser(marshalling) ---> json[] --> sent to clnt
	 */
	// http://host:port/employees , method=POST
	//add new emp details
	@PostMapping
	public Employee addNewEmpDetails(@RequestBody Employee newEmp)
	{
		
		System.out.println("in add emp "+newEmp);//newEmp : transient
		return empService.addEmpDetails(newEmp);
	}
	//http://host:port/employees/1or 2 or 3..., method = GET
	//get emp details  by id
	@GetMapping("/{empId}") //path var or URI template var
	public Employee getEmpDetails(@PathVariable Long empId)
	{
		System.out.println("in get emp "+empId);
		return empService.getEmpDetailsById(empId);
	}
}
