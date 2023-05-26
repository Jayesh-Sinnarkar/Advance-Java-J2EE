package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import dao.StudentDaoImpl;
import pojo.Course;
import pojo.Student;
import utils.HibernetUtils;

public class TestHibernate {

	public static void main(String[] args) {

		try (SessionFactory sf = HibernetUtils.getSession(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl dao = new StudentDaoImpl();

			System.out.println("1. Insert STudent \n" + "2. Validate Student \n"+"3. Get all students from a specific course \n");
			System.out.println("Enter you choice: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			
			case 1: //1. Insert STudent
				System.out.println(
						"firstName, lastName, email, password, confirmPassword, course, admissionFees, dob, regDate");

				Student student = new Student(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
						Course.valueOf(sc.next().toUpperCase()), sc.nextDouble(), LocalDate.parse(sc.next()),
						LocalDate.parse(sc.next()));

				System.out.println(dao.registerStudent(student));
				break;
			
			case 2: //2. Validate Student
				System.out.println("Enter EmailId, Password:");
				try {
				dao.getValidatedStudent(sc.next(), sc.next());
				}catch(RuntimeException e)
				{
					System.out.println("Invalid details could not fetch records from database...");
				}
				break;
				
			case 3:
				System.out.println("Please enter corse name: ");
				Course c = Course.valueOf(sc.next());
				System.out.println(dao.getStudentsOfCourse(c));
				
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
