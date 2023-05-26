package utils;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class HibernetUtils {
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
		System.out.println("in static block"+factory);
		
		
	}

	public static SessionFactory getSession() {
		return factory;
	}

	
	

}
