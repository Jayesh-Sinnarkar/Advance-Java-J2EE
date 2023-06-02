package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	// dep :
	@Autowired // by type : field level D.I
	private SessionFactory sf;

	@Override
	public List<String> getDepartmentNames() {
		String jpql = "select d.deptName from Department d";
		return sf.getCurrentSession()
				.createQuery(jpql, String.class).getResultList();
	}

}
