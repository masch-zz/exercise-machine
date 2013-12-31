package ar.com.masch.exercise.learning.repository.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.book.BookEntity;
import ar.com.masch.exercise.learning.entity.book.ChapterBookEntity;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;
import ar.com.masch.exercise.learning.repository.base.ExerciseLevelBaseRepositoryTest;

public class ChapterBookRepositoryTest extends CRUDRepositoryBaseTest<ChapterBookEntity> {

	@Autowired
	private ChapterBookRepository chapterBookRepository;
	
	@Autowired
	private BookRepositoryTest bookRepositoryTest;
	
	@Autowired
	private ExerciseLevelBaseRepositoryTest exerciseLevelBaseRepositoryTest;
	
	private BookEntity bookEntity1;
	private BookEntity bookEntity2;
	
	@Override
	public void fillElementsSamples() {
		ArrayList<ChapterBookEntity> elementsSamples = new ArrayList<ChapterBookEntity>();

		this.bookEntity1 = this.bookRepositoryTest.getElementsCreated().get(0);
		this.bookEntity2 = this.bookRepositoryTest.getElementsCreated().get(1);
		
		ArrayList<ChapterBookEntity> elementsSamplesByBook2 = new ArrayList<ChapterBookEntity>();
		//Set<ExerciseLevelBaseEntity> exerciseLevelBaseEntitySet = new HashSet<ExerciseLevelBaseEntity>(this.exerciseLevelBaseRepositoryTest.getElementsCreated());		
		
		for (int i = 0; i < 5; ++i) {
			ChapterBookEntity chapterBookEntity1 = new ChapterBookEntity(null, this.bookEntity1, i, "ChapterName" + i/*, exerciseLevelBaseEntitySet*/);
			ChapterBookEntity chapterBookEntity2 = new ChapterBookEntity(null, this.bookEntity2, i + 1, "ChapterName" + i + 1/*, exerciseLevelBaseEntitySet*/);
			
			elementsSamples.add(chapterBookEntity1);
			elementsSamples.add(chapterBookEntity2);
			
			elementsSamplesByBook2.add(chapterBookEntity2);
		}
		
		this.addSamples(elementsSamples);
		this.addSamples(elementsSamplesByBook2);
		
	}

	@Override
	public void searchElements() {
		ArrayList<ChapterBookEntity> elementsSearchedByName = new ArrayList<ChapterBookEntity>();
		
		for (ChapterBookEntity chapterBookEntity : this.getElementsSamples()) {
			//Find By Name
			ChapterBookEntity elementSearchedByName = this.chapterBookRepository.findByName(chapterBookEntity.getName());
			assertNotNull(elementSearchedByName);
			elementsSearchedByName.add(elementSearchedByName);
		}
		
		//Find by Author2
		List<ChapterBookEntity> elementsSearchedByAuthor2 = this.chapterBookRepository.findByBookEntity(this.bookEntity2);
		
		this.addSearched(elementsSearchedByName);
		this.addSearched((ArrayList<ChapterBookEntity>) elementsSearchedByAuthor2);
		
	}

	@Override
	public void assertValues(ChapterBookEntity obj1, ChapterBookEntity obj2) {
		super.assertNotEqualsValuesBase(obj1, obj2);
		
		//assertEquals(obj1.getId(), obj2.getId());
		assertEquals(obj1.getName(), obj2.getName());
		assertEquals(obj1.getNumber(), obj2.getNumber());

		
		this.bookRepositoryTest.assertEqualsValuesBase(obj1.getBookEntity(), obj2.getBookEntity());
//		this.exerciseLevelBaseRepositoryTest.assertEqualsValuesBase(obj1.getExerciseLevelBaseEntityList(), obj2.getExerciseLevelBaseEntityList());
		
	}
	
	@Override
	public void doTest() {
		
		this.bookRepositoryTest.doTest();
		this.exerciseLevelBaseRepositoryTest.doTest();
		super.doTest(this.chapterBookRepository);

	}

}
