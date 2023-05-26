package dao;

import java.util.List;

import pojo.Course;
import pojo.Student;

public interface StudentDao {
	//1. Student registration: Method to register student
	String registerStudent(Student student);
	//2. Student login: 
	//Retrieve student using email and password
	void getValidatedStudent(String email, String passwd);
	//3. Get all students from a specific course
	List<Student> getStudentsOfCourse(Course c);
	//4. Offer scholarship to a particular  student
	

	
	

}
