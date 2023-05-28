package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class GetEmpDetailsByJoinDate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter start date n end join date");
			dao.getSomeEmpDetailsByJoinDate
			(LocalDate.parse(sc.next()), LocalDate.parse(sc.next())) //List<Emp> 
					.forEach(e -> System.out
							.println("Id " + e.getEmpId() + " first Name " + e.getFirstName() + " " + e.getLastName()));
	
			
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
