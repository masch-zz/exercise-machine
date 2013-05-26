package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

@Table(name = "exercise_base")
@Entity(name = "exercise_base")
public class ExerciseBaseEntity extends NameBaseEntity {

	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "LEVEL_ID", nullable = false)
	private LevelBaseEntity levelBaseEntity;

	public ExerciseBaseEntity(Long id, String name, LevelBaseEntity levelBaseEntity) {
		super(id, name);
		this.levelBaseEntity = levelBaseEntity;
	}

	public LevelBaseEntity getLevelBaseEntity() {
		return levelBaseEntity;
	}

	public void setLevelBaseEntity(LevelBaseEntity levelBaseEntity) {
		this.levelBaseEntity = levelBaseEntity;
	}

	@Override
	public String toString() {
		String result = super.toString() + 
				        "\nLevelBase: " + this.levelBaseEntity.toString() + "\n";
		return result;
	}	
}
