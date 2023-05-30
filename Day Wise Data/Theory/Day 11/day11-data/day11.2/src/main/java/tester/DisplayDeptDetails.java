package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.*;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class DisplayDeptDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDaoImpl dao = new DepartmentDaoImpl();
			System.out.println("Enter dept Name");
			Department department = dao.getDepartmentDetails(sc.next());
			System.out.println(department);
			System.out.println("Emps from " + department.getDeptName());
			department.getEmps().forEach(System.out::println);
		} // sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
