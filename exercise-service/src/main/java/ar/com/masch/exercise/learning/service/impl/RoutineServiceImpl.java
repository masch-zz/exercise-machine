package ar.com.masch.exercise.learning.service.impl;

import java.util.Map;

import ar.com.masch.exercise.learning.dto.RoutineDTO;
import ar.com.masch.exercise.learning.service.RoutineService;
import ar.com.masch.exercise.learning.repository.RoutineBaseRepository;

public class RoutineServiceImpl implements RoutineService {

	private Map<String, RoutineDTO> routineDTOMapTest;
	private RoutineBaseRepository routineBaseRepository;

	public void setRoutineDTOMapTest(Map<String, RoutineDTO> routineDTOMapTest) {
		this.routineDTOMapTest = routineDTOMapTest;
	}
	
	public void setRoutineBaseRepository(RoutineBaseRepository routineBaseRepository) {
		this.routineBaseRepository = routineBaseRepository;
	}
	
	public RoutineDTO getRoutine(String name) {
		
		//routineBaseRepository.findByName(name);
		
		RoutineDTO result = this.routineDTOMapTest.get(name);

		return result;
	}

}
