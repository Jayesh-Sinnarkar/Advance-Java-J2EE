package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Department;
import com.app.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	// dep
	@Autowired
	private DepartmentRepository departmentDao;

	@Override
	public List<Department> getAllDepartmens() {

		return departmentDao.findAll();
	}

	@Override
	public Department getDepartmentDetails(long deptId) {
		// TODO Auto-generated method stub
		return departmentDao.findById(deptId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
	}

}
