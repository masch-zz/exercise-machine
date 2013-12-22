package ar.com.masch.exercise.learning.service.impl;

import java.util.Map;

import ar.com.masch.exercise.learning.dto.RoutineDTO;
import ar.com.masch.exercise.learning.service.RoutineService;

public class RoutineServiceImpl implements RoutineService {

	private Map<String, RoutineDTO> routineDTOMapTest;
	 
	

	public void setRoutineDTOMapTest(Map<String, RoutineDTO> routineDTOMapTest) {
		this.routineDTOMapTest = routineDTOMapTest;
	}
	
	public RoutineDTO getRoutine(String name) {
		RoutineDTO result = this.routineDTOMapTest.get(name);

		return result;
	}

}
