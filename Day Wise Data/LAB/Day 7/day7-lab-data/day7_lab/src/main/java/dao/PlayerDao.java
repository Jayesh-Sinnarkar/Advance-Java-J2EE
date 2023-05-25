package dao;

import java.sql.SQLException;

import pojos.Player;

public interface PlayerDao {
//add a method to insert new player details
	String addNewPlayer(Player newPlayer) throws SQLException;
}
