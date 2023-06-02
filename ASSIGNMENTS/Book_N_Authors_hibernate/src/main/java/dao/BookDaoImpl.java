package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

import pojo.Book;

public class BookDaoImpl implements BookDao{

	@Override
	public String registerBook(Book b) {
		String msg = "Could not add Book";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(b);
			tx.commit();
			msg="Book added successfully";
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

}
