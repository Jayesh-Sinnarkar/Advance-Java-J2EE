package dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import pojos.EmpType;
import pojos.Employee;

public interface EmployeeDao {
//add a method for saving new emp details : with openSession
	String insertEmpDetails(Employee newEmp);

	// add a method for saving new emp details : with getCurrentSession
	String insertEmpDetailsWithGetCurrentSession(Employee newEmp);

	// add a method for retriving emp details by PK
	Employee getEmpDetails(int empId);

	// add a method to get all emps
	List<Employee> getAllEmployees();

	// get all emps from the specific type , earning sal between the range
	List<Employee> getSelectedEmployees(EmpType type, double minSal, double maxSal);

	// Update salary for a particular emp by email
	String updateEmpSalary(String email, double salIncr);

	// get all last names of emps joined bet dates.
	List<String> getLastNamesByJoinDate(LocalDate strt, LocalDate end);

	// get emp id , first name, last name of emps joined bet specific dates.
	List<Employee> getSomeEmpDetailsByJoinDate(LocalDate strt, LocalDate end);

	// bulk updation : increment sal of all senior emps
	String bulkUpdateEmpSalary(LocalDate date, double increment);

	// delete emp details for a specific emp
	String deleteEmpDetails(String email);

//save bin image in db
	String saveImage(int empId, String fileName) throws IOException;

	// restore bin image from db
	String restoreImage(int empId, String fileName) throws IOException;
	//persist vs save
	String persistEmpDetails(Employee newEmp);
	

}
