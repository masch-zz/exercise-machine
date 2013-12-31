package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Table(name = "routine_base_exercise_base")
@Entity(name = "routine_base_exercise_base")
public class RoutineExerciseBaseEntity extends BaseEntity {

	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "ROUTINE_BASE_ID", nullable = false)
	private RoutineBaseEntity routineBaseEntity;
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "EXERCISE_LEVEL_BASE_ID", nullable = false)
	private ExerciseLevelBaseEntity exerciseLevelBaseEntity;
	
	@Column(name="POSITION_ORDER", unique=false, nullable = false)
	private Integer positionOrder;
	
	public RoutineExerciseBaseEntity() {
		super();
	}
    
	public RoutineExerciseBaseEntity(Long id, RoutineBaseEntity routineBaseEntity, ExerciseLevelBaseEntity exerciseLevelBaseEntity, Integer positionOrder) {
		super(id);
		this.positionOrder = positionOrder;
		this.routineBaseEntity = routineBaseEntity;
		this.exerciseLevelBaseEntity = exerciseLevelBaseEntity;
	}
    
	public Integer getPositionOrder() {
		return positionOrder;
	}
	
	public void setPositionOrder(Integer positionOrder) {
		this.positionOrder = positionOrder;
	}

	public RoutineBaseEntity getRoutineBaseEntity() {
		return routineBaseEntity;
	}

	public void setRoutineBaseEntity(RoutineBaseEntity routineBaseEntity) {
		this.routineBaseEntity = routineBaseEntity;
	}

	public ExerciseLevelBaseEntity getExerciseLevelBaseEntity() {
		return exerciseLevelBaseEntity;
	}

	public void setExerciseLevelBaseEntity(ExerciseLevelBaseEntity exerciseLevelBaseEntity) {
		this.exerciseLevelBaseEntity = exerciseLevelBaseEntity;
	}
	
}
