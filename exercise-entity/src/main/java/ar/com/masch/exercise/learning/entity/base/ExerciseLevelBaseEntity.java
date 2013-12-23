package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Table(name = "exercise_level_base")
@Entity(name = "exercise_level_base")
public class ExerciseLevelBaseEntity extends BaseEntity {

	@Column(name = "VELOCITY", nullable = true)
	private Long velocity;
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "LEVEL_ID", nullable = false)
	private LevelBaseEntity levelBaseEntity;
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "EXERCISE_BASE_ID", nullable = false)
	private ExerciseBaseEntity exerciseBaseEntity;
	
	public ExerciseLevelBaseEntity() {
		super();
	}
	
	public ExerciseLevelBaseEntity(Long id, LevelBaseEntity levelBaseEntity, ExerciseBaseEntity exerciseBaseEntity, Long velocity) {
		super(id);
		this.velocity = velocity;
		this.levelBaseEntity = levelBaseEntity;
		this.exerciseBaseEntity = exerciseBaseEntity;
	}
	
	public Long getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Long velocity) {
		this.velocity = velocity;
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
		        		"\nVelocity: " + this.velocity.toString() + 
				        "\nLevelBase: " + this.levelBaseEntity.toString() +
				        "\nExerciseBase: " + this.exerciseBaseEntity.toString() + "\n";
		return result;
	}	
}
