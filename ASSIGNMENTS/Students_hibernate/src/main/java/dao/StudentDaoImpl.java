package dao;

import static utils.HibernetUtils.getSession;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Course;
import pojo.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerStudent(Student student) throws HibernateException {

		String msg = "Studnet details not insterted.";
		// getting current session if created otherwise creating new session.
		Session session = getSession().getCurrentSession();
		// Beginning transaction
		Transaction tx = session.beginTransaction();

		try {
			// Inserting a student to table
			Serializable id = session.save(student);
			// commiting a transacton if successfull
			tx.commit();
			// returning sucess message to caller
			msg = "Student inserted successfully.";
		} catch (RuntimeException e) { // rollback trasnaction if transaction failed
			if (tx != null)
				tx.rollback();

			// throw occured exception to the caller.
			throw e;
		}

		return msg;
	}

	@Override
	public void getValidatedStudent(String email, String passwd) {
		Student student = null;
		
		// Select * from dac_students where email=? and password=?
		String jpql = "select s from Student s where s.email=:inemail and s.password=:inpasswd";
		
		// Getting existing session, create one if existing session does not exists
		Session session = getSession().getCurrentSession();
		
		// begining transaction
		Transaction tx = session.beginTransaction();
		try {
			student = session.createQuery(jpql, Student.class)// create query with jpql string
					.setParameter("inemail", email)// setting parameters for email
					.setParameter("inpasswd", passwd).getSingleResult();// setting parameters for password
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("getValidatedStudent "+student);
	}

	@Override
	public List<Student> getStudentsOfCourse(Course c) {
		List student = null;
		String jpql = "select s from Student s where s.course=:incourse";
		Session session = getSession().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			student = session.createQuery(jpql, Student.class).setParameter("incourse",c).getResultList();
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return student;
	}



}
