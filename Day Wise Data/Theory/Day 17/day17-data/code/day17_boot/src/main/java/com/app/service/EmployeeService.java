package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmps();
	Employee addEmpDetails(Employee newEmp);
	Employee getEmpDetailsById(Long empId);
}
