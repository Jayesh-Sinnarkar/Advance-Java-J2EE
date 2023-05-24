package dao;

import java.sql.SQLException;

import pojos.Player;

public interface PlayerDao {
	
	int insertPlayer(Player player) throws SQLException;
}
