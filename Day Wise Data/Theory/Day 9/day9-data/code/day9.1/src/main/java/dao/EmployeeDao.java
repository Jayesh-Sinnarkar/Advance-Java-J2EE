package dao;

import java.util.List;

import pojos.EmpType;
import pojos.Employee;

public interface EmployeeDao {
//add a method for saving new emp details : with openSession
	String insertEmpDetails(Employee newEmp);

	// add a method for saving new emp details : with getCurrentSession
	String insertEmpDetailsWithGetCurrentSession(Employee newEmp);
	//add a method for retriving emp details by PK
	Employee getEmpDetails(int empId);
	//add a method to get all emps
	List<Employee> getAllEmployees();
	//get all emps from the specific type , earning sal between the range
	List<Employee> getSelectedEmployees(EmpType type,double minSal,double maxSal);
	//Update salary for a particular emp by email
	String updateEmpSalary(String email,double salIncr);
}
