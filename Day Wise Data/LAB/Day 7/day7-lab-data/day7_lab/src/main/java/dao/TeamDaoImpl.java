package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import static utils.DBUtils.*;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {
	private Connection cn;
	private PreparedStatement pst1, pst2;

	public TeamDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		pst1 = cn.prepareStatement("select team_id,abbrevation from teams");
		pst2 = cn.prepareStatement("select * from teams where team_id=?");
		System.out.println("team dao created!");
	}

	@Override
	public List<Team> getAllTeams() throws SQLException {
		List<Team> teams = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				teams.add(new Team(rst.getInt(1), rst.getString(2)));
		}
		return teams;
	}

	@Override
	public Team getSelectedTeamDetails(int teamId) throws SQLException {
		// set IN param
		pst2.setInt(1, teamId);
		// exec method : execQuery
		try (ResultSet rst = pst2.executeQuery()) {
			/*
			 * int teamId, String name, String abbrevation, String owner, int maxAge, double
			 * battingAvg, int wicketsTaken)
			 */
			if (rst.next())
				return new Team(teamId, rst.getString(2), 
						rst.getString(3), rst.getString(4), rst.getInt(5),
						rst.getDouble(6), rst.getInt(7));
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		closeConnection();
		System.out.println("team dao cleaned up");
	}

}
