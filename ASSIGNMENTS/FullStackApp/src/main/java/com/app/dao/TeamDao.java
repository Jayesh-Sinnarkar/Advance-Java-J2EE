package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pojo.Team;

public interface TeamDao {
	
	List<Team> getAllTeamDetails()throws SQLException;

}
