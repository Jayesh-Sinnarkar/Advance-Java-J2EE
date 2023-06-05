package com.app.service;

import java.util.List;

import com.app.pojos.Project;

public interface ProjectService {
//add new project
	String launchNewProject(Project newProject);

	List<Project> getAllProjects();

	String assignEmpToProject(Long projectId, Long empId);
}
