package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Address;
import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.pojos.Project;
import com.app.repository.AddressRepository;
import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dep
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository adrRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public List<Employee> getAllEmployeesFromDept(long deptId) {
		return empRepo.findByDeptId(deptId);
	}

	@Override
	public String deleteEmpDetails(long empId) {
		// checking if adr is assigned for this emp , using emp id (=adr id : since
		// @MapsId)
		Optional<Address> optionalAdr = adrRepo.findById(empId);
		if (optionalAdr.isPresent()) // child rec : adr exists ,so first delete that
			adrRepo.delete(optionalAdr.get());
		// what is the relationship between Emp n Project ?
		// Employee *<--------->* Project : both are parents , child : join table
		// (project_emps)
		// You will have to delete those links in the join table , for the emp assigned
		// to the project first
		// n then delete parent emp record
		Employee emp = empRepo.findById(empId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		/*
		 * throwing ConcModificationExc : solve this !!!!! Iterator<Project>
		 * projectItr=emp.getProjects().iterator(); 
		 * projectItr.next().removeEmp(emp);
		 */
		/*
		 * Author author = em.find(Author.class, authorId); //author : inverse
		 * for (Book book :  author.getBooks()) 
		 * { author.removeBook(book); } 
		 * em.remove(author);
		 */
		Iterator<Project> projectItr=emp.getProjects().iterator();
		while(projectItr.hasNext())
			projectItr.next().getEmps().remove(emp);
		empRepo.delete(emp);
		return "Emp Details deleted....";
	}

	@Override
	public String addNewEmployee(long deptId, Employee emp) {
		String mesg = "Adding emp failed";
		// validate confirm password
		if (emp.getPassword().equals(emp.getConfirmPassword())) {
			Department dept = deptRepo.getReferenceById(deptId);
			emp.setDept(dept);
			Employee addeEmp = empRepo.save(emp);
			mesg = "Added new emp with id=" + addeEmp.getId();
		}
		return mesg;

	}

}
