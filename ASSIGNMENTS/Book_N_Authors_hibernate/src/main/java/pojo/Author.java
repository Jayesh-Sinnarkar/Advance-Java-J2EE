package pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author extends BaseEntity {
	@Column(length=40) //, nullable=false
	private String name;
	
	@Column(name="email_id", length=30, unique=true)
	private String email;
	//One to many
	@OneToMany(mappedBy="writer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Book> books = new ArrayList<>();
	
	
	//def const
	public Author()
	{
		
	}
	
	// param const
	public Author(String name, String email) {
		this.name = name;
		this.email = email;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Author [Id="+getId()+"name=" + name + ", email=" + email + "]";
	}
	
	public void addBook(Book b)
	{
		books.add(b);
		b.setWriter(this);
	}
	
	public void removeBook(Book b)
	{
		books.remove(b);
		b.setWriter(null);
	}
}
