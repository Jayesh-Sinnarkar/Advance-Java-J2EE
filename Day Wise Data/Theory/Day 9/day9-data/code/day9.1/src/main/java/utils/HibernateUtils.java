package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		factory = new Configuration() //empty config obj
				.configure().//populated from hib cfg xml
				buildSessionFactory(); //attach singleton SF
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
	

}
