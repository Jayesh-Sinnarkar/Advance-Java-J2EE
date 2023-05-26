package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class StudentRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("Enter new student details : firstName,  lastName,  "
					+ "email,  password,  confirmPassword  chosenCourse,  fees,  dob");
			StudentDaoImpl dao=new StudentDaoImpl();
			Student student1 = new Student(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
					Course.valueOf(sc.next().toUpperCase()), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println(dao.registerNewStudent(student1));
		} // sf.close() => closing /clean up db cn pool(DBCP)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
