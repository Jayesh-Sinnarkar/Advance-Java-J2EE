package dao;

import pojos.Department;

public interface DepartmentDao {
//add new dept details
	String addNewDept(Department dept);
	//get dept details
	Department getDepartmentDetails(String name);
}
