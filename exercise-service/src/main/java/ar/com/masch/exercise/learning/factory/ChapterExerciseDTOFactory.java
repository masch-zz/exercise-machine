package ar.com.masch.exercise.learning.factory;

import ar.com.masch.exercise.learning.dto.exercise.ChapterExerciseDTO;

public class ChapterExerciseDTOFactory {
	
	public ChapterExerciseDTO create(String name, String index) {
		ChapterExerciseDTO chapterDTO = new ChapterExerciseDTO();
		
		chapterDTO.setName(name);
		chapterDTO.setIndex(index);
		
		return chapterDTO;
	}

}
