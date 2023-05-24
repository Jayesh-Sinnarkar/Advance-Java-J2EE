package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {
	private Connection cn;
	private PreparedStatement pst1, pst2;

	
	
	public TeamDaoImpl() throws SQLException{
		//open cn
		cn=openConnection();
		pst1=cn.prepareStatement("select team_id,abbrevation from teams");
		pst2=cn.prepareStatement("select * from teams where team_id=?");
		System.out.println("team dao created!");
	}

	@Override
	public List<Team> getAllTeams() throws SQLException {
		List<Team> teams=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				teams.add(new Team(rst.getInt(1), rst.getString(2)));
		}
		return teams;
	}
	
	public Team getTeam(int team_id) throws SQLException
	{
		Team team=null;
		System.out.println("team_id in getTeam:"+team_id);
		pst2.setInt(1,team_id);
		try(ResultSet rst2=pst2.executeQuery())
		{
			System.out.println("Query Executed for selecting team.");
			if(rst2.next())
			{
				//int teamId, String name, String abbrevation, String owner, int maxAge, double battingAvg, int wicketsTaken
				 team = new Team(rst2.getInt(1), rst2.getString(2),rst2.getString(3),rst2.getString(4),rst2.getInt(5),rst2.getDouble(6),rst2.getInt(7));
			}
		}
		
		return team;
	}
	
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("team dao cleaned up");
	}

}
