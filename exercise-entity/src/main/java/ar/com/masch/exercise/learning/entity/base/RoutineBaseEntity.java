package ar.com.masch.exercise.learning.entity.base;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Table(name = "routine_base")
@Entity(name = "routine_base")
public class RoutineBaseEntity extends NameBaseEntity {

	@ManyToMany(/*fetch = FetchType.LAZY,*/ cascade = CascadeType.ALL)
	@JoinTable(name = "routine_base_exercise_base"/*, catalog = "mkyongdb"*/, 
	           joinColumns = { @JoinColumn(name = "ROUTINE_BASE_ID", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "EXERCISE_BASE_ID") })
	private Set<ExerciseBaseEntity> exercisesBaseEntitiesList;

	public RoutineBaseEntity(Long id, String name, Set<ExerciseBaseEntity> exercisesBaseEntitiesList) {
		super(id, name);
		this.exercisesBaseEntitiesList = exercisesBaseEntitiesList;
	}

	public Set<ExerciseBaseEntity> getExercisesBaseEntitiesList() {
		return exercisesBaseEntitiesList;
	}

	public void setExercisesBaseEntitiesList(Set<ExerciseBaseEntity> exercisesBaseEntitiesList) {
		this.exercisesBaseEntitiesList = exercisesBaseEntitiesList;
	}

}
