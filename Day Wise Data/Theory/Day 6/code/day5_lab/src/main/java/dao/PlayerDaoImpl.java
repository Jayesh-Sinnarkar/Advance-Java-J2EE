package dao;

import java.sql.*;
import static utils.DBUtils.*;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;
	
	

	public PlayerDaoImpl() throws SQLException {
		cn= openConnection();
		pst1=cn.prepareStatement("insert into players (first_name, last_name, dob, batting_avg, wickets_taken, team_id) values (?,?,?,?,?,?)");
	}



	@Override
	public int insertPlayer(String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken,
			int teamId) throws SQLException {
		pst1.setString(1, firstName);
		pst1.setString(2, lastName);
		pst1.setDate(3, dob);
		pst1.setDouble(4, battingAvg);
		pst1.setInt(5, wicketsTaken);
		pst1.setInt(6, teamId);
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
