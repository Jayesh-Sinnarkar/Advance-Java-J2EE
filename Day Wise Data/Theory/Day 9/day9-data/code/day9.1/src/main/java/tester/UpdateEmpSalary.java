package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class UpdateEmpSalary {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter emp email n increment");
			System.out.println(dao.updateEmpSalary(sc.next(), sc.nextDouble()));
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
