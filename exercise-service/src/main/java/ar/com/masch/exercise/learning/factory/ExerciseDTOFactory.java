package ar.com.masch.exercise.learning.factory;

import ar.com.masch.exercise.learning.dto.exercise.ChapterExerciseDTO;
import ar.com.masch.exercise.learning.dto.exercise.ExerciseDTO;
import ar.com.masch.exercise.learning.dto.exercise.LevelExerciseDTO;

public class ExerciseDTOFactory {

	private LevelExerciseDTOFactory levelExerciseDTOFactory;
	private ChapterExerciseDTOFactory chapterExerciseDTOFactory;
	
	public void setLevelExerciseDTOFactory(LevelExerciseDTOFactory levelExerciseDTOFactory) {
		this.levelExerciseDTOFactory = levelExerciseDTOFactory;
	}	

	public void setChapterExerciseDTOFactory(ChapterExerciseDTOFactory chapterExerciseDTOFactory) {
		this.chapterExerciseDTOFactory = chapterExerciseDTOFactory;
	}
	
	public ExerciseDTO create(String exerciseName, String exerciseIndex,
							  ChapterExerciseDTO chapterExerciseDTO, 
							  LevelExerciseDTO levelExerciseDTO) {
		
		ExerciseDTO exerciseDTO = new ExerciseDTO();
		
		exerciseDTO.setName(exerciseName);
		exerciseDTO.setIndex(exerciseIndex);
		
		exerciseDTO.setLevelExerciseDTO(levelExerciseDTO);
		exerciseDTO.setChapterExerciseDTO(chapterExerciseDTO);
		
		return exerciseDTO;
	}
	
	
	public ExerciseDTO create(String exerciseName, String exerciseIndex,
			  				  String chapterName, String chapterIndex, 
			  				  String levelName, String levelIndex) {

		LevelExerciseDTO levelExerciseDTO = this.levelExerciseDTOFactory.create(levelName, levelIndex);
		ChapterExerciseDTO chapterExerciseDTO = this.chapterExerciseDTOFactory.create(chapterName, chapterIndex);
		
		ExerciseDTO exerciseDTO = this.create(exerciseName, exerciseIndex, chapterExerciseDTO, levelExerciseDTO);
		
		return exerciseDTO;
	}	
	
}
