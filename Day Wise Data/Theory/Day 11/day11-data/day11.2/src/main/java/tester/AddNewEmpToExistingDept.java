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

public class AddNewEmpToExistingDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println(
					"Enter emp details : firstName,  lastName,  email,  password,  confirmPassword  joinDate,  type,  salary n dept id");
			Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()), EmpType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			System.out.println(emp.getDept()); //null
			System.out.println(dao.addNewEmp(emp,sc.nextLong()));
		} // sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
