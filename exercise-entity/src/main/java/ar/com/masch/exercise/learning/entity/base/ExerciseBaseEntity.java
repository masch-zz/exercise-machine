package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

@Table(name = "exercise_base")
@Entity(name = "exercise_base")
public class ExerciseBaseEntity extends NameBaseEntity {

	public ExerciseBaseEntity(Long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		String result = super.toString();
		return result;
	}	
}
