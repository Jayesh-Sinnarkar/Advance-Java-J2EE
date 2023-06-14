package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.pojos.Project;
import com.app.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	public ProjectController() {
		System.out.println("in ctor of " + getClass());
	}

	// http://host:port/ems/projects/show
	@GetMapping("/show")
	public String showProjects(Model map) {
		map.addAttribute("projects_list", projectService.getAllProjects());
		return "/projects/show";
	}

	// http://localhost:8080/ems/projects/add
	@GetMapping("/add")
	public String showAddProjectDetailsForm(Project project) {
		System.out.println("add proj form " + project);
		return "/projects/add";
	}

	// http://localhost:8080/ems/projects/add , method=POST
	@PostMapping("/add")
	public String processAddProjectsDetailsForm(Project project, HttpSession session, RedirectAttributes flashMap) {
		System.out.println("process add project " + project);
		flashMap.addFlashAttribute("status", projectService.launchNewProject(project));
		return "redirect:/projects/show";
	}

	// http://localhost:8080/ems/projects/assign_emp/1 , method=GET
	@GetMapping("/assign_emp")
	public String showAssignEmpForm(@RequestParam Long projectId) {
		System.out.println("assign emp form  " + projectId);
		return "/projects/assign_emp";
	}

	// http://localhost:8080/ems/projects/assign_emp , method=POST
	@PostMapping("/assign_emp")
	public String processAssignEmpsForm(@RequestParam Long projectId, @RequestParam Long empId,
			RedirectAttributes flashMap) {
		System.out.println("process assign emp " + projectId + " " + empId);
		flashMap.addFlashAttribute("status", projectService.assignEmpToProject(projectId, empId));
		return "redirect:/projects/show";
	}

}
