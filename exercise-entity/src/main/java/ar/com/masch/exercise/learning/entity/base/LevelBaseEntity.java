package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;

@Table(name = "level")
@Entity(name = "level")
public class LevelBaseEntity extends NameBaseEntity {
	
	public LevelBaseEntity(Long id, String name) {
		super(id, name);
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		return result;
	}	
}
