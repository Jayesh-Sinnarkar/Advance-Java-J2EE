package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	// dep
	@Autowired
	private EntityManager mgr;

	@Override
	public List<String> getAllDepartmentNames() {
		String jpql = "select d.deptName from Department d";
		return mgr.
				createQuery(jpql, String.class).getResultList();
	}

}
