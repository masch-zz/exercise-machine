package ar.com.masch.exercise.learning.dto.exercise;

import ar.com.masch.exercise.learning.dto.exercise.enumsa.ExerciseTypeEnum;

public class RoutineExerciseDTO {
	
	private String name;
	private String level;
	private Integer index;
	private Long velocity;
	private String chapter;
	private String soundFileName;
	private String patternFileName;
	private ExerciseTypeEnum exerciseTypeEnum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Long getVelocity() {
		return velocity;
	}
	public void setVelocity(Long velocity) {
		this.velocity = velocity;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getSoundFileName() {
		return soundFileName;
	}
	public void setSoundFileName(String soundFileName) {
		this.soundFileName = soundFileName;
	}
	public String getPatternFileName() {
		return patternFileName;
	}
	public void setPatternFileName(String patternFileName) {
		this.patternFileName = patternFileName;
	}
	public ExerciseTypeEnum getExerciseTypeEnum() {
		return exerciseTypeEnum;
	}
	public void setExerciseTypeEnum(ExerciseTypeEnum exerciseTypeEnum) {
		this.exerciseTypeEnum = exerciseTypeEnum;
	}

}
