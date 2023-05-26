package tester;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

import dao.EmployeeDaoImpl;

public class GetAllEmps {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory())
		{
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println("All emps ");
			dao.getAllEmployees().forEach(System.out::println);
		} //sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
