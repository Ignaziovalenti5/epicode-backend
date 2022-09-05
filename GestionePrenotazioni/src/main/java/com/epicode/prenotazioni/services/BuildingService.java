package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.models.Building;
import com.epicode.prenotazioni.repositories.BuildingRepository;

@Service
public class BuildingService {
	
	@Autowired
	private BuildingRepository repo;
	
	public List<Building> getAllBuildings() {
		return (List<Building>) repo.findAll();
	}
	
	public Building findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteBuilding(Long id) {
		repo.deleteById(id);
	}
	
	public void create(Building building) {
		repo.save(building);
	}
	
	public void edit(Building building) {
		repo.save(building);
	}
}
