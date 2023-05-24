package pojos;

import java.time.LocalDate;

public class User {
	private String name;
	private String email;
	private String password;
	private LocalDate dob;
	private double regAmount;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String password, LocalDate dob, double regAmount) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.regAmount = regAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dob=" + dob + ", regAmount=" + regAmount + "]";
	}
	

}
