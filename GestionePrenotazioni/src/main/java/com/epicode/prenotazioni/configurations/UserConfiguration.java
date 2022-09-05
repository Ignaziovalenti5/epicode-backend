package com.epicode.prenotazioni.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.prenotazioni.models.User;

@Configuration
public class UserConfiguration {
	
	@Bean("user1")
	public User user1() {
		User u = new User();
		u.setCompleteName("user1");
		u.setEmail("mail@mail.com");
		u.setUsername("username1");
		return u;
	}
	@Bean("user2")
	public User user2() {
		User u = new User();
		u.setCompleteName("user2");
		u.setEmail("mail@mail.com");
		u.setUsername("username2");
		return u;
	}
	@Bean("user3")
	public User user3() {
		User u = new User();
		u.setCompleteName("user3");
		u.setEmail("mail@mail.com");
		u.setUsername("username3");
		return u;
	}
}
