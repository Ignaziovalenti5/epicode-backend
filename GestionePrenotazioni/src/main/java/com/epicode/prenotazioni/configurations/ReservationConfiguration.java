package com.epicode.prenotazioni.configurations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.models.User;
import com.epicode.prenotazioni.models.Workspace;

@Configuration
public class ReservationConfiguration {

	@Autowired @Qualifier("user1")
	private User user1;
	@Autowired @Qualifier("user2")
	private User user2;

	@Autowired @Qualifier("workspace1")
	private Workspace workspace1;
	@Autowired @Qualifier("workspace2")
	private Workspace workspace2;
	
	@Bean("res1")
	public Reservation res1() {
		Reservation res = new Reservation();
		res.setUser(user1);
		res.setWorkspace(workspace1);
		res.setReservationDate(LocalDate.now());
		return res;
	}
	@Bean("res2")
	public Reservation res2() {
		Reservation res2 = new Reservation();
		res2.setUser(user1);
		res2.setWorkspace(workspace2);
		res2.setReservationDate(LocalDate.now());
		return res2;
	}
	@Bean("res3")
	public Reservation res3() {
		Reservation res3 = new Reservation();
		res3.setUser(user2);
		res3.setWorkspace(workspace1);
		res3.setReservationDate(LocalDate.now());
		return res3;
	}
}
