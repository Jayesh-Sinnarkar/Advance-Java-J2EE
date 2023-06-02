package dao;

import pojos.Department;
import pojos.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addNewEmp(Employee newEmp, long deptId) {
		String mesg = "Adding new emp failed !!!!!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// establish a link between emp ---> dept
			// get dept ref from the id
			Department dept = session.get(Department.class, deptId);
			if (dept != null) {
				dept.addEmployee(newEmp);
				mesg = "Added new emp with id=" + newEmp.getId();
			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String removeEmpDetails(String email, String deptName) {
		String mesg = "Removing   emp failed !!!!!!!!";
		String deptJpql = "select d from Department d where d.deptName=:nm";
		String empJpql = "select e from Employee e where e.email=:em";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			Department dept = session.createQuery(deptJpql, Department.class)
					.setParameter("nm", deptName)
					.getSingleResult();
			Employee emp=session.createQuery(empJpql,Employee.class).
					setParameter("em", email).
					getSingleResult();
			//=> dept n emp : PERSISTENT
			dept.removeEmployee(emp);//de linking a bi dir asso.
			mesg="Removed emp details !";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
