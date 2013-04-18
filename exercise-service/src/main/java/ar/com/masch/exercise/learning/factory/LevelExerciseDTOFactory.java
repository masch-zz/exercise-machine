package ar.com.masch.exercise.learning.factory;

import ar.com.masch.exercise.learning.dto.exercise.LevelExerciseDTO;

public class LevelExerciseDTOFactory {

	LevelExerciseDTO create(String name, String index) {
		LevelExerciseDTO levelExerciseDTO = new LevelExerciseDTO();
		
		levelExerciseDTO.setName(name);
		levelExerciseDTO.setIndex(index);
		
		return levelExerciseDTO;
	}
	
}
