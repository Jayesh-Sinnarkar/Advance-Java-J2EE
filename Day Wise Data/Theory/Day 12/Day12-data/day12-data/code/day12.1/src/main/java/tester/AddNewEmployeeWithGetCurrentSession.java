package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class AddNewEmployeeWithGetCurrentSession {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println(
					"Enter emp details : firstName,  lastName,  email,  password,  confirmPassword joinDate type salary");
			Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()), EmpType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			System.out.println("id "+emp.getEmpId());//null
			//set id
			emp.setEmpId(600);//not null id n not having matching rec in db
			System.out.println(dao.insertEmpDetailsWithGetCurrentSession(emp));
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
