package ar.com.masch.exercise.learning.factory;

import ar.com.masch.exercise.learning.dto.exercise.RoutineExerciseDTO;

public class RoutineExerciseDTOFactory {

	public static RoutineExerciseDTO create(String name, Integer index, Long velocity, String level, String chapter) {
		RoutineExerciseDTO result = new RoutineExerciseDTO();
		
		result.setName(name);
		result.setIndex(index);
		result.setLevel(level);
		result.setChapter(chapter);
		result.setVelocity(velocity);
		
		return result;
	}
}
