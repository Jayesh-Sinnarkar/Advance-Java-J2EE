package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="projects")
public class Project extends BaseEntity {
	@Column(unique = true)
	private String title;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	//many-many , bi dir association between entities  Project *<----->* Employee
	//Project : owning , parent , many
	@ManyToMany // mandatory!
	@JoinTable(name="project_emps",
	joinColumns = @JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="emp_id")
	)
	private Set<Employee> emps=new HashSet<>();
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(String title, LocalDate startDate, LocalDate endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	public Project(String title) {
		super();
		this.title = title;
	}
	@Override
	public String toString() {
		return "Project ID "+getId()+" [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	//add helper methods
	public void addEmp(Employee e)
	{
		emps.add(e);
		e.getProjects().add(this);
	}
	public void removeEmp(Employee e)
	{
		emps.remove(e);
		e.getProjects().remove(this);
	}
	
	
}
