package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;

	public PlayerDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// pst1 : insert
		pst1 = cn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("player dao created....");
	}

	@Override
	public String addNewPlayer(Player newPlayer) throws SQLException {
		// set IN params
		/*
		 * String firstName, String lastName, Date dob, double battingAvg, int
		 * wicketsTaken, int teamId
		 */
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, newPlayer.getTeamId());
		//exec update
		int rows=pst1.executeUpdate();
		if(rows == 1)
		return "New Player added to the team";
	
			return "Adding player failed!!!!!";
	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("player dao cleaned up...");
	}

}
