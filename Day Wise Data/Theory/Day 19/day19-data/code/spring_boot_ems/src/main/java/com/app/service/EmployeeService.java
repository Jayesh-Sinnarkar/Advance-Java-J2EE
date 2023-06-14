package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
//get list of emps form specific dept
	List<Employee> getAllEmployeesFromDept(long deptId);

//delete emp details
	String deleteEmpDetails(long empId);

	String addNewEmployee(long deptId, Employee emp);
}
