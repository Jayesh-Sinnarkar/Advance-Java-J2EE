package com.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // mandatory anno to tell Spring sec module
//, to enable web layer security
@Configuration // equivalent to spring bean config xml file .
//Can be used to declare spring  beans
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	//add a dependency
	@Autowired
	private PasswordEncoder enc;
	
	
	//method to return instance of SecurityFilterChain --for the purpose of authorization
	@Bean
	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
		http.authorizeRequests()  //to tell sec frmwork to start authorization of all incoming reqs
		.antMatchers("/products/view").permitAll() //any one can access this url w/o authentication n w/o auth
		.antMatchers("/products/purchase").hasRole("CUSTOMER") //can be accessed post authentication by customer
		.antMatchers("/products/add").hasRole("ADMIN")
		.antMatchers("/products/delete").hasRole("ADMIN")
		.anyRequest().authenticated() //all other remaining reqs can be performed by ANY authenticated user
		.and()
		.httpBasic();//Configures HTTP Basic authentication(1. clnt tries to access any protected resource
		//2. server sends SC 401 , sends resp header WWW-Authenticate
		//3 clnt sends req header : authorization  : Base64 encoded userName:password : clr text
		//4. spring sec uses either in mem /db based credentials --either grants or denies the access(SC 403 : access denied)
		
		//)
		return http.build();
	}
}
