package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

@Table(name = "exercise_base")
@Entity(name = "exercise_base")
public class ExerciseBaseEntity extends NameBaseEntity {

	@Column(name="POSITION_ORDER", unique=false, nullable = false)
	private Integer positionOrder;
	
	public ExerciseBaseEntity() {
		super();
	}
	
	public ExerciseBaseEntity(Long id, Integer positionOrder, String name) {
		super(id, name);
		this.positionOrder = positionOrder;
	}

	@Override
	public String toString() {
		String result = super.toString();
		return result;
	}
	
	public Integer getPositionOrder() {
		return positionOrder;
	}
	
	public void setPositionOrder(Integer positionOrder) {
		this.positionOrder = positionOrder;
	}

}
