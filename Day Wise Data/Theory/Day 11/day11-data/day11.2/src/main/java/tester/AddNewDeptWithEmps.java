package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;
import pojos.EmpType;
import pojos.Employee;

public class AddNewDeptWithEmps {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDaoImpl dao = new DepartmentDaoImpl();
			System.out.println("Enter dept details : location,  deptName");
			Department dept = new Department(sc.next(), sc.next());
			// add 3 emps
			for (int i = 0; i < 3; i++) {
				System.out.println(
						"Enter new emp details : firstName,  lastName,  email,  password,  confirmPassword  joinDate,  type,  salary");
				Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
						LocalDate.parse(sc.next()), EmpType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
				dept.addEmployee(emp);//bi dir link is established!
			}
			System.out.println(dao.addNewDept(dept));
		} // sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
