package com.epicode.prenotazioni.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.models.Reservation;
import com.epicode.prenotazioni.models.User;
import com.epicode.prenotazioni.models.Workspace;
import com.epicode.prenotazioni.repositories.ReservationRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservationService {

	@Autowired
	private ReservationRepository repo;
	
	public List<Reservation> getAllReservetions() {
		return (List<Reservation>) repo.findAll();
	}
	
	public boolean isWorkSpaceAvaliable(Workspace w, LocalDate date) {
		
		List<Reservation> findedRes = repo.findByWorkspaceAndReservationDate(w, date);

		if (findedRes.size()<w.getMaxUser()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasReservationForDay(User u, LocalDate date) {
		List<Reservation> findedRes = repo.findByUserAndReservationDate(u, date);
		if (findedRes.size()>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Reservation findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteReservation(Long id) {
		repo.deleteById(id);
	}
	
	public void create(Reservation res) {
		if (hasReservationForDay(res.getUser(), res.getReservationDate())) {
			log.error("User {} already has reservation for {}",res.getUser().getCompleteName(), res.getReservationDate());
		} else if (!isWorkSpaceAvaliable(res.getWorkspace(), res.getReservationDate())) {
			log.error("{} in {} is not avaible for {}", res.getWorkspace().getDescription(), res.getWorkspace().getBuilding().getAddress().getCity(), res.getReservationDate());
		} else {
			repo.save(res);			
		}
		
	}
	
	public void edit(Reservation res) {
		repo.save(res);
	}
}
