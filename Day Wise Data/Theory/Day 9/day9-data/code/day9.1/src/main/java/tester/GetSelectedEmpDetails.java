package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class GetSelectedEmpDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter emp type n sal range");
			dao.getSelectedEmployees(EmpType.valueOf(sc.next().toUpperCase()),
					sc.nextDouble(),sc.nextDouble()).forEach(System.out::println);
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
