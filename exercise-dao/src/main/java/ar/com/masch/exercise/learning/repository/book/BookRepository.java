package ar.com.masch.exercise.learning.repository.book;

import java.util.List;

import ar.com.masch.exercise.learning.entity.book.BookEntity;
import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.repository.BaseRepository;

public interface BookRepository extends BaseRepository<BookEntity, Long> {

	public BookEntity findByName(String name);
	
	public List<BookEntity> findByAuthorEntity(AuthorEntity authorEntity) ;
}
