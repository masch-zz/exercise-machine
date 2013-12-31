package ar.com.masch.exercise.learning.entity.book;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.entity.base.NameBaseEntity;

@Table(name = "book")
@Entity(name = "book")
public class BookEntity extends NameBaseEntity {

	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "AUTHOR_ID", nullable = false)
	private AuthorEntity authorEntity;
	
	public BookEntity() {
		super();
	}
	
	public BookEntity(Long id, String name, AuthorEntity authorEntity) {
		super(id, name);
		this.authorEntity = authorEntity;
	}

	public AuthorEntity getAuthorEntity() {
		return authorEntity;
	}

	public void setAuthorEntity(AuthorEntity authorEntity) {
		this.authorEntity = authorEntity;
	}
	
	@Override
	public String toString() {
		String result = "\nBook-> " + 
	                    super.toString() + 
		        		this.authorEntity.toString();
		return result;
	}	

}
