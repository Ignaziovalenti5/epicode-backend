package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.models.User;
import com.epicode.prenotazioni.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(3)
@Slf4j
public class UserRunner implements ApplicationRunner {

	@Autowired @Qualifier("user1")
	private User user1;
	@Autowired @Qualifier("user2")
	private User user2;
	@Autowired @Qualifier("user3")
	private User user3;
	@Autowired
	UserService userServ;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("Creating users...");
		userServ.create(user1);
		userServ.create(user2);
		userServ.create(user3);
		log.info(" Users created ");
	}

}
