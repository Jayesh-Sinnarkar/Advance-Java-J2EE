package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//dep : dao layer i/f
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public List<String> getDepartmentNames() {
		// TODO Auto-generated method stub
		return deptDao.getDepartmentNames();
	}

}
