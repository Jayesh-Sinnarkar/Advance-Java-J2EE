package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.EmployeeDaoImpl;
import pojos.EmpType;
import pojos.Employee;

public class RestoreImage {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter emp id , to restore the image ");
			int empId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter image file name along with path");
			System.out.println(dao.restoreImage(empId,sc.nextLine()));
		} // sf.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
