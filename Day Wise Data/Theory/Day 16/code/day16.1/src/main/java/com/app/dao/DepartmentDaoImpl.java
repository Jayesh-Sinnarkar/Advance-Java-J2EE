package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	// dep
	@Autowired //spring supplied
//	@PersistenceContext : JPA supplied 
	private EntityManager manager;

	@Override
	public List<String> getAllDepartmentNames() {
		String jpql = "select d.deptName from Department d";
		return manager.createQuery(jpql, String.class).getResultList();
	}

}
