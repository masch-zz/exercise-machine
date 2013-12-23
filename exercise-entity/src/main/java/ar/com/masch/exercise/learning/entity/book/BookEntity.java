package ar.com.masch.exercise.learning.entity.book;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.entity.base.NameBaseEntity;

@Table(name = "book")
@Entity(name = "book")
public class BookEntity extends NameBaseEntity {

	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "AUTHOR_ID", nullable = false)
	private AuthorEntity authorEntity;
	//private List<ChapterBookEntity> chaptersBookList;

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

	/*public List<ChapterBookEntity> getChaptersBookList() {
		return chaptersBookList;
	}

	public void setChaptersBookList(List<ChapterBookEntity> chaptersBookList) {
		this.chaptersBookList = chaptersBookList;
	}*/

}
