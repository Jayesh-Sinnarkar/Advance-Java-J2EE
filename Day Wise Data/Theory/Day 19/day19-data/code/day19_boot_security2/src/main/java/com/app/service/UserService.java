package com.app.service;

import java.util.List;

import com.app.entities.UserEntity;

//NOTHING TO DO with spring security!!!!
public interface UserService {
	//add a method to insert multiple user recs
	List<UserEntity> saveAllUsers(List<UserEntity> users);
}
