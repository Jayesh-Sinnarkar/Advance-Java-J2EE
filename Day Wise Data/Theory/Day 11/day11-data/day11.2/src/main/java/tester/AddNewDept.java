package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.*;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class AddNewDept {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory())
		{
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println("Enter dept details : location,  deptName");
			Department dept=   new Department(sc.next(), sc.next());
			System.out.println(dao.addNewDept(dept));
		} //sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
