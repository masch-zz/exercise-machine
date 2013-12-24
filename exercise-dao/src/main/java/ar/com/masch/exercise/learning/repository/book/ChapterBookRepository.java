package ar.com.masch.exercise.learning.repository.book;

import java.util.List;

import ar.com.masch.exercise.learning.entity.book.BookEntity;
import ar.com.masch.exercise.learning.repository.BaseRepository;
import ar.com.masch.exercise.learning.entity.book.ChapterBookEntity;

public interface ChapterBookRepository extends BaseRepository<ChapterBookEntity, Long> {

	public ChapterBookEntity findByName(String name);
	
	public List<ChapterBookEntity> findByBookEntity(BookEntity bookEntity);
	
}
