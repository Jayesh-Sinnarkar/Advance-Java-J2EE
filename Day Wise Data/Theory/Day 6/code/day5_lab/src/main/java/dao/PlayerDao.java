package dao;

import java.sql.Date;
import java.sql.SQLException;

public interface PlayerDao {
	
	int insertPlayer(String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken,
			int teamId) throws SQLException;
}
