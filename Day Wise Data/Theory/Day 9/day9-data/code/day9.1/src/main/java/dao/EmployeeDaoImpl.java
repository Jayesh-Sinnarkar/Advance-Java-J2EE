package dao;

import pojos.EmpType;
import pojos.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String insertEmpDetails(Employee newEmp) {
		String mesg = "Inserting emp details failed!!!!!";
		// get session from SF : openSession
		Session session = getFactory().openSession();// brand new session obj created
		Session session2 = getFactory().openSession();
		System.out.println(session == session2);// f

		// begin a tx
		Transaction tx = session.beginTransaction();
		System.out.println("is session open " + session.isOpen() + " conn with DB " + session.isConnected());// t t

		try {
			// CRUD : save
			// Session API : public Serializable save(Object o) throws HibExc
			Serializable id = session.save(newEmp);
			// success
			tx.commit();
			System.out.println(
					"after commit : is session open " + session.isOpen() + " conn with DB " + session.isConnected());// t
																														// t

			mesg = "Inserted emp details with ID : " + id;
		} catch (RuntimeException e) {
			// failure
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		} finally {
			// close session
			if (session != null)
				session.close();// L1 cache is destroyed , pooled out db cn rets to the conn pool.
		}
		System.out.println("is session open " + session.isOpen() + " conn with DB " + session.isConnected());// f f

		return mesg;
	}

	@Override
	public String insertEmpDetailsWithGetCurrentSession(Employee newEmp) {
		// newEmp : TRANSIENT
		String mesg = "Inserting emp details failed!!!!!";
		// get session from SF : openSession
		Session session = getFactory().getCurrentSession();// new session
		Session session2 = getFactory().getCurrentSession();// existing session
		System.out.println(session == session2);// t

		// begin a tx
		Transaction tx = session.beginTransaction();
		System.out.println("is session open " + session.isOpen() + " conn with DB " + session.isConnected());// t t

		try {
			// CRUD : save
			// Session API : public Serializable save(Object o) throws HibExc
			Serializable id = session.save(newEmp);// newEmp : PERSISTENT , DB id not yet!
			// success
			tx.commit();// newEmp : PERSISTENT : gains DB id(insert)
			/*
			 * Hibernate performs auto dirty checking upon commit - --> session.flush() -->
			 * synchs up state of L1 cache with the DB DML (insert) session.close() --> l1
			 * cache is destroyed , db cn rets to the pool --> SO THAT : same db cn can be
			 * REUSED for any other clnt any other request
			 */
			System.out.println(
					"after commit : is session open " + session.isOpen() + " conn with DB " + session.isConnected());// f
																														// f
			mesg = "Inserted emp details with ID : " + id;
		} catch (RuntimeException e) {
			// failure
			if (tx != null)
				tx.rollback();
			/*
			 * 
			 * session.close() cache is destroyed , db cn rets to the pool --> SO THAT :
			 * same db cn can be REUSED for any other clnt any other request
			 */
			System.out.println("is session open " + session.isOpen() + " conn with DB " + session.isConnected());// f f

			// re throw the exc to the caller
			throw e;
		}
		// newEmp : DETACHED (detached from L1 cache , BUT still DB rec exists!)

		return mesg;
	}

	@Override
	public Employee getEmpDetails(int empId) {
		Employee emp = null;// emp : not applicable
		// get session from SF : getcurntsession
		Session session = getFactory().getCurrentSession();
		// begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// Session API : public <T> T get(Class<T> pojoClass,Serializable id) ...
			emp = session.get(Employee.class, empId);// int ---> Integer --> Serializable(up casting)
			// emp != null => PERSISTENT
			emp = session.get(Employee.class, empId);
			emp = session.get(Employee.class, empId);
			emp = session.get(Employee.class, empId);
			tx.commit();// comment this to understand : conn leak issue!!!!!!!!!!!!!!
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emp;// emp : DETACHED
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		// JPQL
		String jpql = "select e from Employee e";
		// get session from SF : getcurntsession
		Session session = getFactory().getCurrentSession();
		// begin a tx
		Transaction tx = session.beginTransaction();
		try {
			empList = session.createQuery(jpql, Employee.class) // Query<Employee>
					.getResultList();
			// empList : list of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return empList;// empList : list of DETACHED entities
	}

	@Override
	public List<Employee> getSelectedEmployees(EmpType type, double minSal, double maxSal) {
		List<Employee> emps = null;
		// JPQL with named IN params
		String jpql = "select e from Employee e where e.type=:emType and e.salary between :min and :max";
		// get session from SF : getcurntsession
		Session session = getFactory().getCurrentSession();
		// begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class)// Query<Emp>
					.setParameter("emType", type).setParameter("min", minSal).setParameter("max", maxSal)
					.getResultList();
			// emps : list of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;// emps : list of detached entities
	}

	@Override
	public String updateEmpSalary(String email1, double salIncr) {
		String mesg="sal updation failed....";
		Employee emp =null;
		String jpql = "select e from Employee e where e.email=:em";
		// get session from SF : getcurntsession
		Session session = getFactory().getCurrentSession();
		// begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp= session.createQuery(jpql, Employee.class).setParameter("em", email1).getSingleResult();
			// => valid email => e : PERSISTENT
			emp.setSalary(emp.getSalary() + salIncr);// updating state of PERSISTENT entity
			tx.commit();
			// hib performs auto dirty chking upon commit
			/*
			 * detects a change -- session.flush() --->DML : update , L1 cache is destroyed
			 * , cn rets to the pool
			 */
			mesg="sal updated....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		//emp : Detached 
		emp.setSalary(emp.getSalary() + salIncr);
		return mesg;
	}

}
