package com.epicode.prenotazioni.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.repositories.ReservationRepository;
import com.epicode.prenotazioni.services.ReservationService;

@SpringBootTest
public class ReservationServiceTest {

	@Autowired @Qualifier("resTest")
	private Reservation res1;
	
	@Autowired
	private ReservationRepository repo;
	
	@Autowired
	private ReservationService service;
	
	@Test
	public void isWorkSpaceAvaibleSuccess() {
		
		repo.save(res1);
		
		boolean isNotAvaible = service.isWorkSpaceAvaliable(res1.getWorkspace(), res1.getReservationDate());
		boolean isAvaible = service.isWorkSpaceAvaliable(res1.getWorkspace(), res1.getReservationDate().plusDays(1));
		
		
		assertThat(isNotAvaible).isFalse();
		assertThat(isAvaible).isTrue();
	}
	
	@Test
	public void hasReservationForDaySuccess() {
		
		repo.save(res1);
		
		boolean hasReservation = service.hasReservationForDay(res1.getUser(), res1.getReservationDate());
		boolean hasNotReservation = service.hasReservationForDay(res1.getUser(), res1.getReservationDate().plusDays(1));
		
		assertThat(hasReservation).isTrue();
		assertThat(hasNotReservation).isFalse();
	}
	
}
