package ar.com.masch.exercise.learning.factory;

import ar.com.masch.exercise.learning.dto.exercise.RoutineExerciseDTO;
import ar.com.masch.exercise.learning.dto.exercise.enumsa.ExerciseTypeEnum;

public class RoutineExerciseDTOFactory {

	public static void complete(String name, Integer index, Long velocity, String level, String chapter, 
			                    ExerciseTypeEnum exerciseTypeEnum, RoutineExerciseDTO result) {
		
		result.setName(name);
		result.setIndex(index);
		result.setLevel(level);
		result.setChapter(chapter);
		result.setVelocity(velocity);
		result.setExerciseTypeEnum(exerciseTypeEnum);
	
	}
	
	public static void completeAudible(String name, Integer index, Long velocity, String level, String chapter,
			                           String soundFileName, RoutineExerciseDTO result) {
		
		complete(name, index, velocity, level, chapter, ExerciseTypeEnum.AudibleExerciseTypeEnum, result);
		result.setSoundFileName(soundFileName);

	}
	
	public static void completeAudiblePattern(String name, Integer index, Long velocity, String level, String chapter,
                                              String soundFileName, String patternFileName, RoutineExerciseDTO result) {

		completeAudible(name, index, velocity, level, chapter, soundFileName, result);
		result.setPatternFileName(patternFileName);
		result.setExerciseTypeEnum(ExerciseTypeEnum.AudiblePatternExerciseTypeEnum);

	}
	
	public static RoutineExerciseDTO create(String name, Integer index, Long velocity, String level, String chapter, 
			                                Integer type, String soundFileName, String patternFileName) {

		RoutineExerciseDTO result = null;
		ExerciseTypeEnum exerciseTypeEnum = ExerciseTypeEnum.valueOf(type);
		
		if (exerciseTypeEnum != null) {
			result = new RoutineExerciseDTO();
			
			switch (exerciseTypeEnum) {
				case AudibleExerciseTypeEnum:
					completeAudible(name, index, velocity, level, chapter, soundFileName, result);
					break;
				
				case AudiblePatternExerciseTypeEnum:
					completeAudiblePattern(name, index, velocity, level, chapter, soundFileName, patternFileName, result);
					break;

			}
		}

		return result;
	}
	
}
