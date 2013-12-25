package ar.com.masch.exercise.learning.entity.book;

import java.util.Set;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import ar.com.masch.exercise.learning.entity.base.NameBaseEntity;
import ar.com.masch.exercise.learning.entity.base.ExerciseLevelBaseEntity;

@Table(name = "chapter_book")
@Entity(name = "chapter_book")
public class ChapterBookEntity extends NameBaseEntity {
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "BOOK_ID", nullable = false)
	private BookEntity bookEntity;
	
	@ManyToMany(/*fetch = FetchType.LAZY,*/ cascade = CascadeType.ALL)
	@JoinTable(name = "exerc_lev_chap_book"/*, catalog = "mkyongdb"*/, 
	           joinColumns = { @JoinColumn(name = "BOOK_ID", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "EXERCISE_LEVEL_BASE_ID") })
	private Set<ExerciseLevelBaseEntity> exerciseLevelBaseEntityList;
	
	public ChapterBookEntity(Long id, String name, BookEntity bookEntity, Set<ExerciseLevelBaseEntity> ExerciseLevelBaseEntityList) {
		super(id, name);
		this.bookEntity = bookEntity;
		this.exerciseLevelBaseEntityList = ExerciseLevelBaseEntityList;
	}
	
	public BookEntity getBookEntity() {
		return bookEntity;
	}
	
	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}
	
	public Set<ExerciseLevelBaseEntity> getExerciseLevelBaseEntityList() {
		return exerciseLevelBaseEntityList;
	}
	
	public void setExerciseLevelBaseEntityList(Set<ExerciseLevelBaseEntity> exerciseLevelBaseEntityList) {
		this.exerciseLevelBaseEntityList = exerciseLevelBaseEntityList;
	}

}
