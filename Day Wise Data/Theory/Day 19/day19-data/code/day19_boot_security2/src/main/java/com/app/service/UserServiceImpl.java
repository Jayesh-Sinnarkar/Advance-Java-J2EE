package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.UserEntity;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// dep
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder enc;

	@Override
	public List<UserEntity> saveAllUsers(List<UserEntity> users) {
		// encode passwords of all users , before saving the details
		users.forEach(user -> user.setPassword(enc.encode(user.getPassword())));
		return userRepo.saveAll(users);
	}

}
