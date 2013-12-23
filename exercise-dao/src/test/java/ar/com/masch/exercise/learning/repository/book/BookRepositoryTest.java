package ar.com.masch.exercise.learning.repository.book;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.book.BookEntity;
import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;
import ar.com.masch.exercise.learning.repository.base.AuthorRepositoryTest;

public class BookRepositoryTest extends CRUDRepositoryBaseTest<BookEntity> {

	@Autowired
	private BookRepository bookRepository;	

	@Autowired
	private AuthorRepositoryTest authorRepositoryTest;
	
	private AuthorEntity authorEntity1;
	private AuthorEntity authorEntity2;
	
	@Override
	public void fillElementsSamples() {
		
		ArrayList<BookEntity> elementsSamples = new ArrayList<BookEntity>();

		this.authorEntity1 = this.authorRepositoryTest.getElementsCreated().get(0);
		this.authorEntity2 = this.authorRepositoryTest.getElementsCreated().get(1);
		ArrayList<BookEntity> elementsSamplesByAuthor2 = new ArrayList<BookEntity>();
		
		
		for (int i = 0; i < 5; ++i) {
			BookEntity bookEntityAuthor1 = new BookEntity(null, "BookName" + i, authorEntity1);
			BookEntity bookEntityAuthor2 = new BookEntity(null, "BookName" + i + 1, authorEntity2);
			
			elementsSamples.add(bookEntityAuthor1);
			elementsSamples.add(bookEntityAuthor2);
			
			elementsSamplesByAuthor2.add(bookEntityAuthor2);
		}
		
		this.addSamples(elementsSamples);
		this.addSamples(elementsSamplesByAuthor2);

	}

	@Override
	public void searchElements() {

		ArrayList<BookEntity> elementsSearchedByName = new ArrayList<BookEntity>();
		
		for (BookEntity bookEntity : this.getElementsSamples()) {
			//Find By Name
			BookEntity elementSearchedByName = this.bookRepository.findByName(bookEntity.getName());
			assertNotNull(elementSearchedByName);
			elementsSearchedByName.add(elementSearchedByName);
		}
		
		//Find by Author2
		List<BookEntity> elementsSearchedByAuthor2 = this.bookRepository.findByAuthorEntity(this.authorEntity2);
		
		this.addSearched(elementsSearchedByName);
		this.addSearched((ArrayList<BookEntity>) elementsSearchedByAuthor2);

	}
	
	@Override
	public void assertValues(BookEntity obj1, BookEntity obj2) {

		super.assertNotEqualsValuesBase(obj1, obj2);
		
		//assertEquals(obj1.getId(), obj2.getId());
		assertEquals(obj1.getName(), obj2.getName());

		this.authorRepositoryTest.assertEqualsValuesBase(obj1.getAuthorEntity(), obj2.getAuthorEntity());
		
	}
	
	@Test
	public void doTest() {

		this.authorRepositoryTest.doTest();
		super.doTest(this.bookRepository);

	}
	
}