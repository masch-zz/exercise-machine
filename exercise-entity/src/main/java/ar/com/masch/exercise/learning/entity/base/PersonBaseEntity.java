package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.EqualsBuilder;

@MappedSuperclass
public class PersonBaseEntity extends NameBaseEntity {

	// TODO: Ver la diferencia de length y la definicion de la longitud del varchar
	@Column(name = "LAST_NAME", nullable = false, length = 40, columnDefinition = "VARCHAR(40)")
	private String lastName;

	@Column(name = "FIRST_NAME", nullable = false, length = 40, columnDefinition = "VARCHAR(40)")
	private String firstName;

	@Column(name = "MIDDLE_NAME", nullable = false, length = 40, columnDefinition = "VARCHAR(40)")
	private String middleName;

	public PersonBaseEntity(Long id, String name, String lastName, String firstName, String middleName) {
		super(id, name);
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Override
	public boolean equals(Object obj) {
	
        AuthorEntity rhs = (AuthorEntity) obj;
        
        return new EqualsBuilder().
        	appendSuper(super.equals(obj)).
            append(lastName, rhs.getLastName()).
            append(middleName, rhs.getMiddleName()).
            append(firstName, rhs.getFirstName()).
            isEquals();

	}
	

}
