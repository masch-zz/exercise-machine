package ar.com.masch.exercise.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>{

	AuthorEntity findByName(String name);
	
}
