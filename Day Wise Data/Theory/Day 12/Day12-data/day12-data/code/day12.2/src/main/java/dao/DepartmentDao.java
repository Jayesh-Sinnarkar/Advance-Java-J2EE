package dao;

import java.util.List;

import pojos.Department;

public interface DepartmentDao {
//add new dept details
	String addNewDept(Department dept);

	// get dept details only
	Department getDepartmentDetails(String name);

	// get dept + emps details
	Department getDepartmentAndEmpDetails(String name);
	
	//get all departments + emp details
	List<Department> getAllDepartments();
}
