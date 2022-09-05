package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.models.Building;
import com.epicode.prenotazioni.services.BuildingService;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class BuildingRunner implements ApplicationRunner {

	@Autowired @Qualifier("building1")
	private Building building1;
	@Autowired @Qualifier("building2")
	private Building building2;
	@Autowired @Qualifier("building3")
	private Building building3;
	@Autowired @Qualifier("building4")
	private Building building4;
	@Autowired
	BuildingService serv;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("Creating buildings...");
		serv.create(building1);
		serv.create(building2);
		serv.create(building3);
		serv.create(building4);
		log.info(" Buildings created ");
		
	}

}
