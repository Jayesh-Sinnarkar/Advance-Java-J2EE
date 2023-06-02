package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity // To tell hibernate , following class in an entity , i.e it's life cycle has to
		// be managed by hib frmwork
@Table(name = "emps") // for specifying table name
public class Employee extends BaseEntity {

	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Column(length = 30, unique = true) // =>unique
	private String email;
	@Column(nullable = false) // =>NOT NULL
	private String password;
	@Transient // => skip from persistence , NO column for confirmPassword
	private String confirmPassword;
	@Column(name = "join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private EmpType type;
	@Lob // large object :col : longblob
	private byte[] image;
	private double salary;
	// many to one association
	@ManyToOne
	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
	private Department dept;
	// many-to many
	@ManyToMany(mappedBy = "emps")
	private Set<Project> projects = new HashSet<>();
	// one to one association Employee ----> AdharCard
//	@Embedded // OPTIONAL
//	private AdhaarCard card;
//	// Employee HAS-A skills (string)
//	@ElementCollection // mandatory
//	@CollectionTable(name = "emp_skills", joinColumns = @JoinColumn(name = "emp_id"))
//	@Column(name = "skill_name", length = 20)
//	private List<String> skills = new ArrayList<>();
//	// one to many association between Employee 1--->* PaymentCard
//	@ElementCollection
//	@CollectionTable(name = "emp_payment_cards", 
//	joinColumns = @JoinColumn(name = "emp_id"))
//	private List<PaymentCard> cards = new ArrayList<>();

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String email, String password, String confirmPassword,
			LocalDate joinDate, EmpType type, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmpType getType() {
		return type;
	}

	public void setType(EmpType type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

//	public AdhaarCard getCard() {
//		return card;
//	}
//
//	public void setCard(AdhaarCard card) {
//		this.card = card;
//	}

	// Tip : NEVER add any association fields in toString : o.w will
	// cause infinite recursion --causing stack overflow
	@Override
	public String toString() {
		return "Employee [empId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
