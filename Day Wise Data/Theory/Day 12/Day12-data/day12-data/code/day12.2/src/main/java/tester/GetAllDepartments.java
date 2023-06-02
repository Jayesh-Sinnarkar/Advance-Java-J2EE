package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.*;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class GetAllDepartments {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDaoImpl dao = new DepartmentDaoImpl();
			dao.getAllDepartments().forEach(dept -> {
				System.out.println("Dept details");
				System.out.println(dept);
				System.out.println("Emp details ");
				dept.getEmps().forEach(System.out::println);
			});
		} // sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
