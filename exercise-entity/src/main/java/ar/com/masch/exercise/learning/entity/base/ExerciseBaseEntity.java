package ar.com.masch.exercise.learning.entity.base;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

public class ExerciseBaseEntity extends BaseEntity {

	private LevelBaseEntity levelBaseEntity;
	private ExerciseBaseEntity exerciseBaseEntity;
	
	public LevelBaseEntity getLevelBaseEntity() {
		return levelBaseEntity;
	}
	
	public void setLevelBaseEntity(LevelBaseEntity levelBaseEntity) {
		this.levelBaseEntity = levelBaseEntity;
	}
	
	public ExerciseBaseEntity getExerciseBaseEntity() {
		return exerciseBaseEntity;
	}
	
	public void setExerciseBaseEntity(ExerciseBaseEntity exerciseBaseEntity) {
		this.exerciseBaseEntity = exerciseBaseEntity;
	}
	
}
