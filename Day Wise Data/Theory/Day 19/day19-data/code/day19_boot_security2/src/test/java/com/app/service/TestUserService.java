package com.app.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@SpringBootTest // enables entire spring boot config --controller/service/repo
class TestUserService {
	@Autowired
	private UserService userService;

	@Test
	void testSaveAllUsers() {
		List<UserEntity> users = List.of(
				new UserEntity("a1", "b1", "a1@gmail.com", "12345", UserRole.ROLE_ADMIN),
				new UserEntity("a2", "b2", "a2@gmail.com", "16345", UserRole.ROLE_CUSTOMER));
		List<UserEntity> users2=userService.saveAllUsers(users);
		assertEquals(2, users2.size());
	}

}
