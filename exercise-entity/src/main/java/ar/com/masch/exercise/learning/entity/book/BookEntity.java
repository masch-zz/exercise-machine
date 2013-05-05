package ar.com.masch.exercise.learning.entity.book;

import java.util.List;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.entity.base.NameBaseEntity;

public class BookEntity extends NameBaseEntity {

	private AuthorEntity authorEntity;
	private List<ChapterBookEntity> chaptersBookList;

	public BookEntity(Long id, String name) {
		super(id, name);
	}

	public AuthorEntity getAuthorEntity() {
		return authorEntity;
	}

	public void setAuthorEntity(AuthorEntity authorEntity) {
		this.authorEntity = authorEntity;
	}

	public List<ChapterBookEntity> getChaptersBookList() {
		return chaptersBookList;
	}

	public void setChaptersBookList(List<ChapterBookEntity> chaptersBookList) {
		this.chaptersBookList = chaptersBookList;
	}

}
