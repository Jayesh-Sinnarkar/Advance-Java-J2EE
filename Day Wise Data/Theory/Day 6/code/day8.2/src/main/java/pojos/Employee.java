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
@Table(name = "emps")
public class Employee {
	@Id // => PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // => auto_increment
	@Column(name="emp_id")
	private Integer empId;
	@Column(name="first_name",length = 30)
	private String firstName;
	@Column(name="last_name",length = 30)
	private String lastName;
	@Column(name="email",length = 30,unique = true)
	private String email;	
	private String password;
	@Transient
	private String confirmPassword;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private EmpType type;
	@Lob
	private byte[] image;

	public Employee() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + "]";
	}

}
