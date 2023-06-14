package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Employee;
import com.app.pojos.Project;
import com.app.repository.EmployeeRepository;
import com.app.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public String launchNewProject(Project newProject) {
		return "Launched new project with ID=" + projectRepo.save(newProject).getId();
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public String assignEmpToProject(Long projectId, Long empId) {
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project ID!!!!"));
		Employee emp = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!"));
		project.addEmp(emp);//
		return "Emp "+emp.getFirstName()+" added to Project : "+project.getTitle();
	}

}
