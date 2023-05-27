package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book extends BaseEntity {
	@Column(length=100, unique=true)
	private String title;
	//many to one
	@ManyToOne
	private Author writer;
	//default cnstr
	public Book()
	{
		
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getWriter() {
		return writer;
	}

	public void setWriter(Author writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", getId()=" + getId() + "]";
	}

	

}
