package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

@Table(name = "exercise_base")
@Entity(name = "exercise_base")
public class ExerciseBaseEntity extends NameBaseEntity {
	
	@Column(name="EXERCISE_BASE_TYPE", unique=false, nullable = false)
	private Integer type;
	
	@Column(name="POSITION_ORDER", unique=false, nullable = false)
	private Integer positionOrder;
		
	@Column(name="PATTERN_FILE_NAME", unique=false, nullable = true)
	private String patternFileName;
	
	public ExerciseBaseEntity() {
		super();
	}
	
	public ExerciseBaseEntity(Long id, Integer type, Integer positionOrder, String name, String patternFileName) {
		super(id, name);
		this.type = type;
		this.positionOrder = positionOrder;
		this.patternFileName = patternFileName;
	}

	@Override
	public String toString() {
		String result = "\nExerciseBaseEntity-> " + super.toString() +
				        "\nPositionOrder: " + this.positionOrder +
				        "\nPatternFileName: " + this.patternFileName;
		
		return result;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getPositionOrder() {
		return positionOrder;
	}
	
	public void setPositionOrder(Integer positionOrder) {
		this.positionOrder = positionOrder;
	}
	
	public String getPatternFileName() {
		return patternFileName;
	}
	
	public void setPatternFileName(String patternFileName) {
		this.patternFileName = patternFileName;
	}

}
