package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.models.WorkspaceType;
import com.epicode.prenotazioni.models.Workspace;
import com.epicode.prenotazioni.repositories.WorkspaceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WorkspaceService {
	
	@Autowired
	private WorkspaceRepository repo;
	
	
	public List<Workspace> getAllWorkspaces() {
		return (List<Workspace>) repo.findAll();
	}
	
	public Workspace findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteWorkspace(Long id) {
		repo.deleteById(id);
	}
	
	public void create(Workspace workspace) {
		repo.save(workspace);
	}
	
	public void edit(Workspace workspace) {
		repo.save(workspace);
	}

	public List<Workspace> getWorkspaceByCityAndType(String city, WorkspaceType type){
		List<Workspace> found = repo.findByCityAndType(city, type);
		log.info("{} workspace in {} found:", found.size(), city);
		for (Workspace workspace : found) {
			log.info("{} - {} - {}", workspace.getDescription(), workspace.getBuilding().getAddress().getCity(), workspace.getBuilding().getAddress().getAddress()); 
		}
		return found;
	}
}
