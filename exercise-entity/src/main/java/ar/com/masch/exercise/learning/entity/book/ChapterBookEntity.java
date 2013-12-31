package ar.com.masch.exercise.learning.entity.book;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import ar.com.masch.exercise.learning.entity.base.NameBaseEntity;

@Table(name = "chapter_book")
@Entity(name = "chapter_book")
public class ChapterBookEntity extends NameBaseEntity {
	
	@ManyToOne()
	@JoinColumn(name = "BOOK_ID", nullable = false)
	private BookEntity bookEntity;
	
	@Column(name="NUMBER", unique=false, nullable = false)
	private Integer number;
	
	public ChapterBookEntity(Long id, BookEntity bookEntity, Integer number, String name) {
		super(id, name);
		this.number = number;
		this.bookEntity = bookEntity;
	}
	
	public ChapterBookEntity() {
		super();
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public BookEntity getBookEntity() {
		return bookEntity;
	}
	
	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}
	
	@Override
	public String toString() {
		String result = "\nChapterBook-> " + 
	                    super.toString() + 
				        "\nNumber: " + this.number +
						this.bookEntity.toString(); 
		return result;
	}	

}
