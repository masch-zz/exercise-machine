package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Table(name = "exercise_level_base")
@Entity(name = "exercise_level_base")
public class ExerciseLevelBaseEntity extends BaseEntity {

	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "LEVEL_ID", nullable = false)
	private LevelBaseEntity levelBaseEntity;
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "EXERCISE_BASE_ID", nullable = false)
	private ExerciseBaseEntity exerciseBaseEntity;
	
	public ExerciseLevelBaseEntity() {
		super();
	}
	
	public ExerciseLevelBaseEntity(Long id, LevelBaseEntity levelBaseEntity, ExerciseBaseEntity exerciseBaseEntity) {
		super(id);
		this.levelBaseEntity = levelBaseEntity;
		this.exerciseBaseEntity = exerciseBaseEntity;
	}
	
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
	
	@Override
	public String toString() {
		String result = super.toString() + 
				        "\nLevelBase: " + this.levelBaseEntity.toString() + "\n" +
				        "\nExerciseBase: " + this.exerciseBaseEntity.toString() + "\n";
		return result;
	}	
}
