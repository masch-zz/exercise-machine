package ar.com.masch.exercise.learning.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.masch.exercise.learning.repository.book.BookRepositoryTest;
import ar.com.masch.exercise.learning.repository.base.AuthorRepositoryTest;
import ar.com.masch.exercise.learning.repository.base.LevelBaseRepositoryTest;
import ar.com.masch.exercise.learning.repository.base.RoutineBaseRepositoryTest;
import ar.com.masch.exercise.learning.repository.book.ChapterBookRepositoryTest;
import ar.com.masch.exercise.learning.repository.base.ExerciseBaseRepositoryTest;
import ar.com.masch.exercise.learning.repository.base.ExerciseLevelBaseRepositoryTest;
import ar.com.masch.exercise.learning.repository.base.RoutineExerciseBaseRespositoryTest;

//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercise-repository-test-context.xml")
public class RunnableCRUDRepositoryBaseTest<T> {

	@Autowired
	private AuthorRepositoryTest authorRepositoryTest;
	
	@Autowired
	private ExerciseBaseRepositoryTest exerciseBaseRepositoryTest;
	
	@Autowired
	private ExerciseLevelBaseRepositoryTest exerciseLevelBaseRepositoryTest;

	@Autowired
	private LevelBaseRepositoryTest levelBaseRepositoryTest;
	
	@Autowired
	private RoutineBaseRepositoryTest routineBaseRepositoryTest;
	
	@Autowired
	private RoutineExerciseBaseRespositoryTest routineExerciseBaseRespositoryTest;
	
	@Autowired
	private BookRepositoryTest bookRepositoryTest;
	
	@Autowired
	private ChapterBookRepositoryTest chapterBookRepositoryTest;
	
	@Test
	public void testAuthorRepository() {
		
		this.authorRepositoryTest.doTest();

		this.exerciseBaseRepositoryTest.doTest();

		this.exerciseLevelBaseRepositoryTest.doTest();

		this.levelBaseRepositoryTest.doTest();

		this.routineBaseRepositoryTest.doTest();
	
		this.routineExerciseBaseRespositoryTest.doTest();

		this.bookRepositoryTest.doTest();

		this.chapterBookRepositoryTest.doTest();
	}
	
}
