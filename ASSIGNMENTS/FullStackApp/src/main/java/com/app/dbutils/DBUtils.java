package com.app.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.*;


public class DBUtils {
	private static Connection cn;

	public static Connection openConnection(String url,String uname,String passwd) throws SQLException
	{
		cn= DriverManager.getConnection(url,uname,passwd);
		return cn;
	}

}
