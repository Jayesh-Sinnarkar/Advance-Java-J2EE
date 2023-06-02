package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class GetEmpLastNamesByJoinDate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter start date n end join date");
			dao.getLastNamesByJoinDate(LocalDate.parse(sc.next()), LocalDate.parse(sc.next()))
					.forEach(System.out::println);
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
