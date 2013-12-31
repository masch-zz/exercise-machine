package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;

@Table(name = "routine_base")
@Entity(name = "routine_base")
public class RoutineBaseEntity extends NameBaseEntity {

	/*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "routine_base_exercise_base", catalog = "mkyongdb", 
	           joinColumns = { @JoinColumn(name = "EXERCISE_LEVEL_BASE_ID", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "ROUTINE_BASE_ID") })
	private Set<ExerciseLevelBaseEntity> exercisesLevelBaseEntitiesList;*/
	
	public RoutineBaseEntity() {
		super();
	}
	
	public RoutineBaseEntity(Long id, String name/*, Set<ExerciseLevelBaseEntity> exercisesLevelBaseEntitiesList*/) {
		super(id, name);
		//this.exercisesLevelBaseEntitiesList = exercisesLevelBaseEntitiesList;
	}
	
	/*public Set<ExerciseLevelBaseEntity> getExercisesLevelBaseEntitiesList() {
		return exercisesLevelBaseEntitiesList;
	}

	public void setExercisesLevelBaseEntitiesList(Set<ExerciseLevelBaseEntity> exercisesLevelBaseEntitiesList) {
		this.exercisesLevelBaseEntitiesList = exercisesLevelBaseEntitiesList;
	}*/

}
