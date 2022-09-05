package com.epicode.prenotazioni.workspace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.prenotazioni.models.Building;
import com.epicode.prenotazioni.models.WorkspaceType;
import com.epicode.prenotazioni.models.Workspace;

@Configuration
public class WorkspaceConfigTest {
	
	@Autowired @Qualifier("sedeRoma")
	private Building sedeRoma;

	@Bean("workspaceTest")
	public Workspace newOpenspace() {
		Workspace w = new Workspace();
		w.setBuilding(sedeRoma);
		w.setDescription("Open Space Sede Roma");
		w.setMaxUser(10);
		w.setType(WorkspaceType.MEETINGROOM);
		return w;
	}
}
