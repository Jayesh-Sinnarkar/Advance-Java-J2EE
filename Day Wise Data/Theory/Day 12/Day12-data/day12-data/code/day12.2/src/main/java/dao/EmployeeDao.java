package dao;

import pojos.Employee;

public interface EmployeeDao {
//add new emp under existing dept
	String addNewEmp(Employee newEmp, long deptId);
	//remove emp details from the specified dept
	String removeEmpDetails(String email,String deptName);
}
