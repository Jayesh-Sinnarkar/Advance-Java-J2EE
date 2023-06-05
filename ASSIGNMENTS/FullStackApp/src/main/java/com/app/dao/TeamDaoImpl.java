package com.app.dao;

import static com.app.dbutils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Team;

public class TeamDaoImpl implements TeamDao {
	private Connection cn;
	private Statement statement;
	private ResultSet rst;

	public TeamDaoImpl(String url,String uname,String passwd) throws SQLException  {
		cn = openConnection(url,uname,passwd);
		statement =  cn.createStatement();
		
	}

	@Override
	public List<Team> getAllTeamDetails() throws SQLException {
		List<Team> teams = new ArrayList<>();
		 rst = statement.executeQuery("select * from teams");
		while(rst.next())
		{
			teams.add(new Team(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDouble(6), rst.getInt(7)));
		}
		
		return teams;
	}
	
	public void close() throws SQLException
	{
		if(rst!=null)
			rst.close();
	}

}
