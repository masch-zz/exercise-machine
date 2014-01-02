package ar.com.masch.exercise.learning.dto.exercise.enumsa;

public enum ExerciseTypeEnum {

	AudibleExerciseTypeEnum(1),
	AudiblePatternExerciseTypeEnum(2);
	
	private Integer value;
	
	private ExerciseTypeEnum(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static ExerciseTypeEnum valueOf(Integer value) {
		ExerciseTypeEnum result = null;
		
		if (value.compareTo(AudibleExerciseTypeEnum.getValue()) == 0) {
			result = AudibleExerciseTypeEnum;
		}
		else if (value.compareTo(AudiblePatternExerciseTypeEnum.getValue()) == 0) {
			result = AudiblePatternExerciseTypeEnum;
		}
		
		return result;
	}
	
}
