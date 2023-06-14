package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.UserEntity;
import com.app.repository.UserRepository;

//creating a service layer bean , to provide custom imple of UserDetailsService
//purpose : to fetch user details from db 
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	// dep : dao layer i/f
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// load the details from dao layer
		UserEntity user = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Email !!!!"));
		// => valid email --> create instance of imple class of UserDetails i/f n ret it
		// to the caller
		return new CustomUserDetails(user);
	}

}
