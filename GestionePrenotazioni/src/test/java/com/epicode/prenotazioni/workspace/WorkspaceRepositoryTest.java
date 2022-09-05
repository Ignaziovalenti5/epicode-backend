package com.epicode.prenotazioni.workspace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.epicode.prenotazioni.models.WorkspaceType;
import com.epicode.prenotazioni.models.Workspace;
import com.epicode.prenotazioni.repositories.WorkspaceRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class WorkspaceRepositoryTest {

	@Autowired @Qualifier("workspaceTest")
	private Workspace w;
	
	@Autowired
	private WorkspaceRepository repo;
	
	@Test
	public void findByCityAndTypeSuccess() {
		
		repo.save(w);
		List<Workspace> found = repo.findByCityAndType("Roma", WorkspaceType.MEETINGROOM);

		assertThat(found).isNotEmpty();
	}
	
	@Test
	public void findByCityAndTypeNotFound() {
		
		List<Workspace> found = repo.findByCityAndType("RM", WorkspaceType.MEETINGROOM);
		
		assertThat(found).isEmpty();
	}
	
}
