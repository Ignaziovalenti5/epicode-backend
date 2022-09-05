package com.epicode.prenotazioni.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.models.User;
import com.epicode.prenotazioni.models.Workspace;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

	List<Reservation> findByWorkspaceAndReservationDate(Workspace w, LocalDate date);
	
	List<Reservation> findByUserAndReservationDate(User u, LocalDate date);

}
