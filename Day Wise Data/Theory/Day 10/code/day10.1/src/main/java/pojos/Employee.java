package pojos;

import java.time.LocalDate;

import javax.persistence.*;

/*
 * emps table 
emp_id(PK) ,first_name,last_name,email(unique),
password,join_date,emp_type(full_time/part_time/contract...)
 */
@Entity // To tell hibernate , following class in an entity , i.e it's life cycle has to
		// be managed by hib frmwork
@Table(name = "emps")//for specifying table name
public class Employee {
	@Id // => PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // => auto_increment
	@Column(name="emp_id")
	private Integer empId;
	@Column(name="first_name",length = 30)
	private String firstName;
	@Column(name="last_name",length = 30)
	private String lastName;
	@Column(length = 30,unique = true)//=>unique 
	private String email;	
	@Column(nullable = false)//=>NOT NULL
	private String password;
	@Transient//=> skip from persistence , NO column  for confirmPassword
	private String confirmPassword;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING)//col : varchar => enum constant name
	@Column(length = 30)
	private EmpType type;
	@Lob//large object :col : longblob
	private byte[] image;
	private double salary;

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
	public Employee(Integer empId, String firstName, String lastName) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// setters n getters
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + ", salary=" + salary + "]";
	}


	

}
