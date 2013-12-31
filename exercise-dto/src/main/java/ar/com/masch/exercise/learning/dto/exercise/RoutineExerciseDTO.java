package ar.com.masch.exercise.learning.dto.exercise;

public class RoutineExerciseDTO {
	
	private String name;
	private String level;
	private Integer index;
	private Long velocity;
	private String chapter;
	
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

}
