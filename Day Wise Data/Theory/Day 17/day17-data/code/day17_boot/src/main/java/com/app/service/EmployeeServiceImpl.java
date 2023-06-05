package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excceptions.ResourceNotFoundException;
import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dep
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmps() {
		return empRepo.findAll();
	}// service layer rets list of DETACHED emps to the caller

	@Override
	public Employee addEmpDetails(Employee newEmp) {
		// TODO Auto-generated method stub
		return empRepo.save(newEmp);// rets PERSISTENT entity
	}// rets DETACHED emp to the caller

	@Override
	public Employee getEmpDetailsById(Long empId) {
		
		return empRepo.findById(empId).
				orElseThrow(() -> 
				new ResourceNotFoundException("Invalid emp id !!!!!"));
	}//in case of valid id : service layer rets -- tx.commit 
	//: detached emp to the caller
	//on case invalid id -- tx.rollback -- exc is thrown !

}
