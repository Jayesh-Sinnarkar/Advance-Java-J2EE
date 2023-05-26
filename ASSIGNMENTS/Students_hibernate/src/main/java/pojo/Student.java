package pojo;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "dac_students")
public class Student {
	// studentId (PK) ,first name , last
	// name,email,password,confirmPassword,course(enum),
	// admission fees (double) ,dob : LocalDate/Date regDate , profilePic : byte[]
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increament constraint suitable for MySQL database
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(name = "email_id", length = 60, unique = true)
	private String email;
	@Column(name = "password", length = 30)
	private String password;
	@Transient
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Course course;
	@Column(name = "Fees")
	private double admissionFees;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "regDate")
	private LocalDate regDate;
	@Lob
	@Column(name = "profile_pic")
	private byte[] profilePic;

	// Default Const
	public Student() {

	}

	public Student(String firstName, String lastName, String email, String password, String confirmPassword,
			Course course, double admissionFees, LocalDate dob, LocalDate regDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.course = course;
		this.admissionFees = admissionFees;
		this.dob = dob;
		this.regDate = regDate;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public double getAdmissionFees() {
		return admissionFees;
	}

	public void setAdmissionFees(double admissionFees) {
		this.admissionFees = admissionFees;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", course=" + course
				+ ", admissionFees=" + admissionFees + ", dob=" + dob + ", regDate=" + regDate + "]";
	}

}
