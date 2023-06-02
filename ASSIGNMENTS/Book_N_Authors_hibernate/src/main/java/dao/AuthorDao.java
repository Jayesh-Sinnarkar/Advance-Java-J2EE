package dao;

import pojo.Author;
import pojo.Book;

public interface AuthorDao {
	
	String registerAuthorWithBooks(Author author);
	String publishBookWithAuthor(Book book, String email);

}
