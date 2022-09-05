package com.epicode.prenotazioni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.models.WorkspaceType;
import com.epicode.prenotazioni.models.Workspace;

@Repository
public interface WorkspaceRepository extends CrudRepository<Workspace, Long> {

	@Query("SELECT w FROM Workspace w WHERE w.building.address.city =:city AND w.type =:type")
	public List<Workspace> findByCityAndType(String city, WorkspaceType type);
	
}
