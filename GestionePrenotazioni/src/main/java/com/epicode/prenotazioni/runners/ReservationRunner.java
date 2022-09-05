package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.services.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(4)
@Slf4j
public class ReservationRunner implements ApplicationRunner {

	@Autowired
	private ReservationService serv;
	
	@Autowired @Qualifier("res1")
	private Reservation res1;
	@Autowired @Qualifier("res2")
	private Reservation res2;
	@Autowired @Qualifier("res3")
	private Reservation res3;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("Making some reservations...");

		serv.create(res1);
		serv.create(res2);
		serv.create(res3);
		
		log.info(" Reservations added ");
		
	}

}
