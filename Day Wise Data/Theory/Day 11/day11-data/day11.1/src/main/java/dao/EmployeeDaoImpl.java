package dao;

import pojos.EmpType;
import pojos.Employee;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
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
		Employee emp = null;// emp :none of the POJO states are applicable
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
		String mesg = "sal updation failed....";
		Employee emp = null;
		String jpql = "select e from Employee e where e.email=:em";
		// get session from SF : getcurntsession
		Session session = getFactory().getCurrentSession();
		// begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp = session.createQuery(jpql, Employee.class)
					.setParameter("em", email1).getSingleResult();
			// => valid email => emp : PERSISTENT
			
			emp.setSalary(emp.getSalary() + salIncr);// updating state of PERSISTENT entity
		//	session.evict(emp); un comment to chk persistent --> detached , cancelling update!
			tx.commit();
			// hib performs auto dirty chking upon commit
			/*
			 * detects a change -- session.flush() --->DML : update , L1 cache is destroyed
			 * , cn rets to the pool
			 */
			mesg = "sal updated....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		// emp : Detached
		emp.setSalary(emp.getSalary() + salIncr);
		return mesg;
	}

	@Override
	public List<String> getLastNamesByJoinDate(LocalDate strt, LocalDate end) {
		List<String> lastNames = null;
		String jpql = "select e.lastName from Employee e where e.joinDate between :st and :end1";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("st", strt).setParameter("end1", end)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return lastNames;
	}

	@Override
	public List<Employee> getSomeEmpDetailsByJoinDate(LocalDate strt, LocalDate end) {
		List<Employee> list = null;
		String jpql = "select new pojos.Employee(empId,firstName,lastName) from Employee e where e.joinDate between :strt and :end";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			list = session.createQuery(jpql, Employee.class).setParameter("strt", strt).setParameter("end", end)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public String bulkUpdateEmpSalary(LocalDate date, double increment) {
		String mesg = "Sal updation failed!!!!!";
		String jpql = "update Employee e set e.salary=e.salary+:incr where e.joinDate < :dt";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("incr", increment).setParameter("dt", date)
					.executeUpdate();
			// L1 cache : EMPTY , no cascading of update operation 
			//on the child auto,
			// does not support opti. locking
			tx.commit();
			mesg = "Updated sal for " + updateCount + " no of emps...";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String deleteEmpDetails(String email) {
		String mesg = "deletion of emp details failed!!!!!!!!!!!";
		String jpql = "select e from Employee e where e.email=:em";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Employee e = session.createQuery(jpql, Employee.class)
					.setParameter("em", email).getSingleResult();
			// NO NULL checking !!!!!!!!!!!!
			// e : PERSISTENT
			// mark the entity for removal
			session.delete(e);// e : REMOVED
			tx.commit();// auto dirty chking --session.flush() --DML : delete , session.close : l1 cache
						// destoyed : e : TRANSIENT , pooled out db cn
//rets to the conn pool
			mesg = e.getFirstName() + " " + e.getLastName() + " 's details deleted....";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}// e : marked for GC

	@Override
	public String saveImage(int empId, String fileName) throws IOException {
		StringBuilder mesg = new StringBuilder("Image storing status : ");
		// get emp details from id
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp : persistent
				// validate file
				File file = new File(fileName);//File cls instance : wraps path to a file/folder
				if (file.isFile() && file.canRead()) {
					// readable data file
					emp.setImage(FileUtils.readFileToByteArray(file));// File ---> byte[]
					mesg.append("Success!!!!!");
				} else
					mesg.append("Failed --invalid image file!!!!");
			} else
				mesg.append("Failed -- invalid emp id !!!!");
			tx.commit();// hib : session.flush() --> update
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg.toString();
	}

	@Override
	public String restoreImage(int empId, String fileName) throws IOException {
		StringBuilder mesg = new StringBuilder("Image re storing status : ");
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp : persistent , chk if img exists
				byte[] image = emp.getImage();
				if (image != null) {
					FileUtils.writeByteArrayToFile(new File(fileName), image);
					mesg.append("Success....");
				} else
					mesg.append("Failed : Image not available");
			} else
				mesg.append("Failed : invalid emp id!!!!!");
			tx.commit();//No DML 
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg.toString();
	}
	@Override
	public String persistEmpDetails(Employee newEmp) {
		String mesg = "Persisting emp details failed!!!!!";
		// get session from SF :get curnt session
		Session session = getFactory().getCurrentSession();// brand new session obj created
	// begin a tx
		Transaction tx = session.beginTransaction();	
		try {
			// CRUD : persist
			// Session API : public void persist(Object o) throws HibExc
			session.persist(newEmp);
			//newEmp : PERSISTENT
			// success
			tx.commit();
			mesg = "Persisted emp details with ID : " +newEmp.getEmpId();
		} catch (RuntimeException e) {
			// failure
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		} 
	
		return mesg;
	}


}
