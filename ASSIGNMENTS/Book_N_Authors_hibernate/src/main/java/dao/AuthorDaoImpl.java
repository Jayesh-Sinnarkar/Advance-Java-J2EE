package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Author;
import pojo.Book;;

public class AuthorDaoImpl implements AuthorDao{

	@Override
	public String registerAuthorWithBooks(Author author) {
		String msg = "Could not add Author and Books";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(author);
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String publishBookWithAuthor(Book book, String email) {
		String msg="Could not add book with author";
		String jpql = "select a from Author a where email_id=:em";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Author auth = session.createQuery(jpql,Author.class).setParameter("em", email).getSingleResult();
			session.persist(book);
			book.setWriter(auth);
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
