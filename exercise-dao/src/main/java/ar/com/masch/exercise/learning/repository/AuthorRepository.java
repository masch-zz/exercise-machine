package ar.com.masch.exercise.learning.repository;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;

public interface AuthorRepository extends BaseRepository<AuthorEntity, Long> {

	public AuthorEntity findByName(String name);
	
	public AuthorEntity findByLastName(String lastName);
	
}
