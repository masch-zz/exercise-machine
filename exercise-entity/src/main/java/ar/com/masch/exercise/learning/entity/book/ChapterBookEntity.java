package ar.com.masch.exercise.learning.entity.book;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import ar.com.masch.exercise.learning.entity.base.NameBaseEntity;

@Table(name = "chapter_book")
@Entity(name = "chapter_book")
public class ChapterBookEntity extends NameBaseEntity {
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "BOOK_ID", nullable = false)
	private BookEntity bookEntity;
	
	public ChapterBookEntity(Long id, String name, BookEntity bookEntity) {
		super(id, name);
		this.bookEntity = bookEntity;
	}
	
	public BookEntity getBookEntity() {
		return bookEntity;
	}
	
	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}
	
	
	/*private List<ExerciseBaseEntity> exercisesBookList;

	public ChapterBookEntity(Long id, String name) {
		super(id, name);
	}	

	public List<ExerciseBaseEntity> getExercisesBookList() {
		return exercisesBookList;
	}
	
	public void setExercisesBookList(List<ExerciseBaseEntity> exercisesBookList) {
		this.exercisesBookList = exercisesBookList;
	}*/

}
