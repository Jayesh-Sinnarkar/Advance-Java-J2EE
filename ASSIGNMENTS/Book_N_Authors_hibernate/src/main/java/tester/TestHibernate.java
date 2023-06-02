package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AuthorDaoImpl;
import pojo.Author;
import pojo.Book;

public class TestHibernate {

	public static void main(String[] args) {
		boolean exit = false;
		AuthorDaoImpl dao = new AuthorDaoImpl();
		
		try(SessionFactory sf=getFactory(); Scanner sc = new Scanner(System.in))
		{
			while(!exit)
			{
				System.out.println("<<<<<MENU>>>>>"
						+"\n 1. Add author with books"
						+"\n 2.Publish book with authors"
						+"\n 3. Exit");
				System.out.println("Enter your choice: ");
				int ch = sc.nextInt();
				sc.nextLine();
				
				switch(ch)
				{
				case 1://1. Add author with books
					System.out.println("Enter Author Name and email: ");
					Author author = new Author(sc.next(), sc.next());
					sc.nextLine();
					System.out.println("Enter Book1 Name: ");
					Book b1 = new Book(sc.nextLine());
					System.out.println("Enter Book2 Name: ");
					Book b2 = new Book(sc.nextLine());
					author.addBook(b1);
					author.addBook(b2);
					dao.registerAuthorWithBooks(author);
					break;
					
				case 2: //2.Publish book with authors
					System.out.println("Enter Author email:");
					String email = sc.nextLine();
					System.out.println("Enter Book title:");
					Book book = new Book(sc.nextLine());
					dao.publishBookWithAuthor(book, email);

					break;
					
				case 3:
					exit=true;
					break;
				
				}
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
