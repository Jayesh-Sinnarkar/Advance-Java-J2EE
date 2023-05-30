package dao;

import pojos.Department;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String addNewDept(Department dept) {
		String mesg = "Adding new dept failed !!!!!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(dept);// dept : persistent
			tx.commit();
			mesg = "Added new dpet with id=" + dept.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Department getDepartmentDetails(String name) {
		Department dept = null;
		String deptJpql = "select d from Department d where d.deptName=:nm";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			dept = session.createQuery(deptJpql, Department.class).setParameter("nm", name).getSingleResult();
			// dept : persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;// dept : Detached !
	}

	@Override
	public Department getDepartmentAndEmpDetails(String name) {
		Department dept = null;
		String deptJpql = "select d from Department d left outer join fetch d.emps where d.deptName=:nm";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			dept = session.createQuery(deptJpql, Department.class).
					setParameter("nm", name).getSingleResult(); // select
																												// :
																												// dept
			// dept : persistent
			// simply access size of collection
			// dept.getEmps().size();//another select : emps table
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;// dept : Detached !
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> depts = null;
		String deptJpql = "select distinct d from Department d left  join fetch d.emps";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			depts = session.createQuery(deptJpql, Department.class)
					.getResultList();
			
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return depts;//List of detached entities
	}

}
