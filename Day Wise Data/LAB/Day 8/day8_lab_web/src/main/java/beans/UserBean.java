package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.UserDao;
import pojos.User;

public class UserBean {
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String passowrd;
	private String dob;
	private UserDao usrDao;
	
	

	public UserBean() {
		
	}
	
	//Const
	public UserBean(String firstName, String lastName, String emailId, String passowrd, String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.passowrd = passowrd;
		this.dob = dob;
	}

	//Getters and Setters
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


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassowrd() {
		return passowrd;
	}


	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public UserDao getUsrDao() {
		return usrDao;
	}

	public void setUsrDao(UserDao usrDao) {
		this.usrDao = usrDao;
	}
	
	//BL methods: to add new voter after validations
	
	public String registerVoter() throws SQLException
	{
		System.out.println("Register Voter"+firstName+" "+dob);
		LocalDate date = LocalDate.parse(dob);
		int age = Period.between(date,LocalDate.now()).getYears();
		
		if(age>21)
		{
			User newVoter = new User(firstName, lastName, emailId, passowrd,Date.valueOf(dob));		
			usrDao.registerNewVoter(newVoter);
		}
		return null;
		
	}
	
	
	

}
