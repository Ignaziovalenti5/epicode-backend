package com.epicode.prenotazioni.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.repositories.ReservationRepository;

@SpringBootTest
public class ReservationRepositoryTest {

	@Autowired @Qualifier("resTest")
	private Reservation resTest;
	
	@Autowired
	private ReservationRepository repo;
	
	@Test
	public void findByWorkspaceAndReservationDateSuccess() {
		
		repo.save(resTest);
		List<Reservation> found = repo.findByWorkspaceAndReservationDate(resTest.getWorkspace(), resTest.getReservationDate());
		
		assertThat(found).isNotEmpty();
		
	}
	
	@Test
	public void findByUserAndReservationDateSuccess() {
		
		repo.save(resTest);
		List<Reservation> found = repo.findByUserAndReservationDate(resTest.getUser(), resTest.getReservationDate());
		
		assertThat(found).isNotEmpty();
		
	}
	
	@Test
	public void findByWorkspaceAndReservationDateNotFound() {
		
		List<Reservation> found = repo.findByWorkspaceAndReservationDate(resTest.getWorkspace(), resTest.getReservationDate().plusDays(2));
		
		assertThat(found).isEmpty();
		
	}
	
	@Test
	public void findByUSerAndReservationDateNotFound() {
		
		List<Reservation> found = repo.findByUserAndReservationDate(resTest.getUser(), resTest.getReservationDate().plusDays(2));
		
		assertThat(found).isEmpty();
		
	}
}
