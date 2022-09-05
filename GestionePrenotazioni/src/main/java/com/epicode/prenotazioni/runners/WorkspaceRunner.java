package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.models.WorkspaceType;
import com.epicode.prenotazioni.models.Workspace;
import com.epicode.prenotazioni.services.WorkspaceService;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(2)
@Slf4j
public class WorkspaceRunner implements ApplicationRunner {

	@Autowired @Qualifier("workspace1")
	private Workspace workspace1;
	@Autowired @Qualifier("workspace2")
	private Workspace workspace2;
	@Autowired @Qualifier("workspace3")
	private Workspace workspace3;
	@Autowired @Qualifier("workspace4")
	private Workspace workspace4;
	@Autowired @Qualifier("workspace5")
	private Workspace workspace5;
	
	@Autowired
	private WorkspaceService workspaceService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("Creating workspaces...");
		workspaceService.create(workspace1);
		workspaceService.create(workspace2);
		workspaceService.create(workspace3);
		workspaceService.create(workspace4);
		workspaceService.create(workspace5);	
		log.info(" Workspaces created! ");
		
		workspaceService.getWorkspaceByCityAndType("City", WorkspaceType.OPENSPACE);
		
	}

}
