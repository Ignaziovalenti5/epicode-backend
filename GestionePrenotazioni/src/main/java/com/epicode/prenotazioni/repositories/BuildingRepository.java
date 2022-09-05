package com.epicode.prenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.models.Building;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {

}
