package ar.com.masch.exercise.learning.dto;
//Test
import java.util.List;

import ar.com.masch.exercise.learning.dto.exercise.ExerciseDTO;

public class RoutineDTO {

	private String name;
	private List<ExerciseDTO> exerciseDTOList;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ExerciseDTO> getExerciseDTOList() {
		return exerciseDTOList;
	}
	
	public void setExerciseDTOList(List<ExerciseDTO> exerciseDTOList) {
		this.exerciseDTOList = exerciseDTOList;
	}
}
