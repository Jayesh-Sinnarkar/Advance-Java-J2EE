package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.EmpType;
import pojos.Employee;

public class RemoveEmpDetailsFromDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println(
					"Enter emp email n dept name");
					System.out.println(dao.removeEmpDetails(sc.next(), sc.next()));
		} // sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
