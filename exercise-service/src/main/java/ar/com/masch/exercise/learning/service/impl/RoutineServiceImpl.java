package ar.com.masch.exercise.learning.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.dto.RoutineDTO;
import ar.com.masch.exercise.learning.service.RoutineService;
import ar.com.masch.exercise.learning.repository.AuthorRepository;
import ar.com.masch.exercise.learning.repository.RoutineBaseRepository;

public class RoutineServiceImpl implements RoutineService {

	private Map<String, RoutineDTO> routineDTOMapTest;
	@Autowired
	private RoutineBaseRepository routineBaseRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	public void setRoutineDTOMapTest(Map<String, RoutineDTO> routineDTOMapTest) {
		this.routineDTOMapTest = routineDTOMapTest;
	}
	
	public void setRoutineBaseRepository(RoutineBaseRepository routineBaseRepository) {
		this.routineBaseRepository = routineBaseRepository;
	}
	
	public RoutineDTO getRoutine(String name) {
		
		/*List<RoutineBaseEntity>	routineBaseEntityList = routineBaseRepository.findAll();// findByName(name);
		
		for (Iterator iterator = routineBaseEntityList.iterator(); iterator.hasNext();) {
			RoutineBaseEntity routineBaseEntity = (RoutineBaseEntity) iterator.next();
			
		}
		
		List<AuthorEntity> authorEntities =  this.authorRepository.findAll();
		for (Iterator iterator = authorEntities.iterator(); iterator.hasNext();) {
			AuthorEntity authorEntity = (AuthorEntity) iterator.next();
			
			authorEntity.getFirstName();
			
		}*/
		
		RoutineDTO result = this.routineDTOMapTest.get(name);

		return result;
	}

}
