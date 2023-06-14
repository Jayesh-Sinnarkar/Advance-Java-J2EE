package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Day19BootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day19BootSecurityApplication.class, args);
	}
	//configure password encoder bean
	@Bean //Indicates that a method produces a bean to be managed by the Spring container. 
    public PasswordEncoder encoder()
    {
		return new BCryptPasswordEncoder();
    }
}
