package com.epicode.prenotazioni.reservation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.models.User;
import com.epicode.prenotazioni.models.Workspace;

@Configuration
public class ReservationConfigTest {

	@Autowired @Qualifier("fraverdi")
	private User verdi;
	@Autowired @Qualifier("ufficio")
	private Workspace ufficio;

	@Bean("resTest")
	public Reservation resTest() {
		Reservation res = new Reservation();
		res.setUser(verdi);
		res.setWorkspace(ufficio);
		res.setReservationDate(LocalDate.now());
		return res;
	}
	
}
