package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;

import org.apache.commons.lang.builder.EqualsBuilder;

@Table(name = "author")
@Entity(name = "author")
public class AuthorEntity extends PersonBaseEntity {

	public AuthorEntity() {
		super();
	}
	
	public AuthorEntity(Long id, String name, String lastName, String firstName, String middleName) {
		super(id, name, lastName, firstName, middleName);
	}

	@Override
	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (obj == this) {
//			return true;
//		}
//		if (!(obj instanceof AuthorEntity)) {
//			return false;
//		}
//		
//		return super.equals(obj);
		   return EqualsBuilder.reflectionEquals(this, obj);		
	}
	
	@Override
	public String toString() {
		String result = "\nAuthor-> " + super.toString();
		
		return result;
	}	

}
