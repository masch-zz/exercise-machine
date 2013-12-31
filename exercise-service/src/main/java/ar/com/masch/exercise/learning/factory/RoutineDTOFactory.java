package ar.com.masch.exercise.learning.factory;

import java.util.List;

import ar.com.masch.exercise.learning.dto.RoutineDTO;
import ar.com.masch.exercise.learning.dto.exercise.RoutineExerciseDTO;

public class RoutineDTOFactory {

	public static RoutineDTO create(String name, List<RoutineExerciseDTO> routineExerciseDTOList) {
		RoutineDTO result = new RoutineDTO();
		
		result.setName(name);
		result.setRoutineExerciseDTOList(routineExerciseDTOList);
		
		return result;
	}
}
