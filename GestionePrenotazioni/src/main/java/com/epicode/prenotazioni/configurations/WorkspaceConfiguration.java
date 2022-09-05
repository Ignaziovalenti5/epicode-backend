package com.epicode.prenotazioni.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.prenotazioni.models.Building;
import com.epicode.prenotazioni.models.WorkspaceType;
import com.epicode.prenotazioni.models.Workspace;

@Configuration
public class WorkspaceConfiguration {

	@Autowired @Qualifier("building1")
	private Building building1;
	@Autowired @Qualifier("building2")
	private Building building2;
	@Autowired @Qualifier("building3")
	private Building building3;
	@Autowired @Qualifier("building4")
	private Building building4;
	
	@Bean("workspace1")
	public Workspace workspace1() {
		Workspace w = new Workspace();
		w.setBuilding(building1);
		w.setDescription("description1");
		w.setMaxUser(20);
		w.setType(WorkspaceType.MEETINGROOM);
		return w;
	}

	@Bean("workspace2")
	public Workspace workspace2() {
		Workspace w = new Workspace();
		w.setBuilding(building2);
		w.setDescription("description2");
		w.setMaxUser(10);
		w.setType(WorkspaceType.OPENSPACE);
		return w;
	}
	
	@Bean("workspace3")
	public Workspace workspace3() {
		Workspace w = new Workspace();
		w.setBuilding(building3);
		w.setDescription("description3");
		w.setMaxUser(1);
		w.setType(WorkspaceType.PRIVATE);
		return w;
	}
	@Bean("workspace4")
	public Workspace workspace4() {
		Workspace w = new Workspace();
		w.setBuilding(building4);
		w.setDescription("description4");
		w.setMaxUser(1);
		w.setType(WorkspaceType.PRIVATE);
		return w;
	}
	@Bean("workspace5")
	public Workspace workspace5() {
		Workspace w = new Workspace();
		w.setBuilding(building1);
		w.setDescription("description5");
		w.setMaxUser(4);
		w.setType(WorkspaceType.OPENSPACE);
		return w;
	}
}
