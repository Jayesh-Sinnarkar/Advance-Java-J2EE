package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class AddNewEmployeeWithOpenSession {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println(
					"Enter emp details : firstName,  lastName,  email,  password,  confirmPassword joinDate type salary");
			Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()), EmpType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			System.out.println(dao.insertEmpDetails(emp));
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
