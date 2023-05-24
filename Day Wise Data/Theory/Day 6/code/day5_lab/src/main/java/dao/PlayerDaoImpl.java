package dao;

import java.sql.*;

import pojos.Player;

import static utils.DBUtils.*;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;
	
	

	public PlayerDaoImpl() throws SQLException {
		cn= openConnection();
		pst1=cn.prepareStatement("insert into players (first_name, last_name, dob, batting_avg, wickets_taken, team_id) values (?,?,?,?,?,?)");
	}



	@Override
	public int insertPlayer(Player player) throws SQLException {
		pst1.setString(1, player.getFirstName());
		pst1.setString(2, player.getLastName());
		pst1.setDate(3, player.getDob());
		pst1.setDouble(4, player.getBattingAvg());
		pst1.setInt(5, player.getWicketsTaken());
		pst1.setInt(6, player.getTeamId());
		return pst1.executeUpdate();	
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("player dao cleaned up");
	}

}
