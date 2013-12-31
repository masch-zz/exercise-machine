package ar.com.masch.exercise.learning.dto.exercise;

import java.util.List;

public class RoutineDTO {

	private String name;
	private List<RoutineExerciseDTO> routineExerciseDTOList;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<RoutineExerciseDTO> getRoutineExerciseDTOList() {
		return this.routineExerciseDTOList;
	}
	
	public void setRoutineExerciseDTOList(List<RoutineExerciseDTO> routineExerciseDTOList) {
		this.routineExerciseDTOList = routineExerciseDTOList;
	}
}
