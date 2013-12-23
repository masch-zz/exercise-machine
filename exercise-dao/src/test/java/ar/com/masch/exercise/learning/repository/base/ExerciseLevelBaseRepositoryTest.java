package ar.com.masch.exercise.learning.repository.base;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;
import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;
import ar.com.masch.exercise.learning.entity.base.ExerciseLevelBaseEntity;
import ar.com.masch.exercise.learning.repository.ExerciseLevelBaseRepository;

public class ExerciseLevelBaseRepositoryTest extends CRUDRepositoryBaseTest<ExerciseLevelBaseEntity>{

	@Autowired
	private LevelBaseRepositoryTest levelBaseRepositoryTest;
	
	@Autowired
	private ExerciseBaseRepositoryTest exerciseBaseRepositoryTest;
	
	@Autowired
	private ExerciseLevelBaseRepository exerciseLevelBaseRepository;
	
	private LevelBaseEntity levelBaseEntity1;
	private LevelBaseEntity levelBaseEntity2;
	private ExerciseBaseEntity exerciseBaseEntity1;
	private ExerciseBaseEntity exerciseBaseEntity2;
	
	@Override
	public void fillElementsSamples() {
		ArrayList<ExerciseLevelBaseEntity> elementsSamples = new ArrayList<ExerciseLevelBaseEntity>();
		
		this.levelBaseEntity1 = this.levelBaseRepositoryTest.getElementsCreated().get(0);
		this.levelBaseEntity2 = this.levelBaseRepositoryTest.getElementsCreated().get(1);
		this.exerciseBaseEntity1 = this.exerciseBaseRepositoryTest.getElementsCreated().get(0);
		this.exerciseBaseEntity2 = this.exerciseBaseRepositoryTest.getElementsCreated().get(1);
		
		ArrayList<ExerciseLevelBaseEntity> elementsSamplesByLevelBase1 = new ArrayList<ExerciseLevelBaseEntity>();
		ArrayList<ExerciseLevelBaseEntity> elementsSamplesByExerciseBase2 = new ArrayList<ExerciseLevelBaseEntity>();
		
		for (int i = 0; i < 5; ++i) {
			ExerciseLevelBaseEntity exerciseLevelBaseEntity1 = new ExerciseLevelBaseEntity(null, this.levelBaseEntity1, this.exerciseBaseEntity1, 10L);
			ExerciseLevelBaseEntity exerciseLevelBaseEntity2 = new ExerciseLevelBaseEntity(null, this.levelBaseEntity2, this.exerciseBaseEntity2, null);
			
			elementsSamples.add(exerciseLevelBaseEntity1);
			elementsSamples.add(exerciseLevelBaseEntity2);
			
			//Creo 5 elementos con level 1 para buscarlos despues
			elementsSamplesByLevelBase1.add(exerciseLevelBaseEntity1);
			
			//Creo 5 elementos con exercise 2 para buscarlos despues
			elementsSamplesByExerciseBase2.add(exerciseLevelBaseEntity2);
		}
		
		this.addSamples(elementsSamplesByLevelBase1);
		this.addSamples(elementsSamplesByExerciseBase2);
		
	}

	@Override
	public void searchElements() {
		
		//Find By Level
		List<ExerciseLevelBaseEntity> elementSearchedByLevel = this.exerciseLevelBaseRepository.findByLevelBaseEntity(this.levelBaseEntity1);
		this.addSearched((ArrayList<ExerciseLevelBaseEntity>) elementSearchedByLevel);
		
		//Find By Exercise
		List<ExerciseLevelBaseEntity> elementSearchedByExercise = this.exerciseLevelBaseRepository.findByExerciseBaseEntity(this.exerciseBaseEntity2);
		this.addSearched((ArrayList<ExerciseLevelBaseEntity>) elementSearchedByExercise);
		
	}

	@Override
	public void assertValues(ExerciseLevelBaseEntity obj1, ExerciseLevelBaseEntity obj2) {
		super.assertNotEqualsValuesBase(obj1, obj2);
		
		assertEquals(obj1.getVelocity(), obj2.getVelocity());
		
		this.levelBaseRepositoryTest.assertEqualsValuesBase(obj1.getLevelBaseEntity(), obj2.getLevelBaseEntity());
		this.exerciseBaseRepositoryTest.assertEqualsValuesBase(obj1.getExerciseBaseEntity(), obj2.getExerciseBaseEntity());
		
	}
	
	@Test
	public void doTest() {

		this.levelBaseRepositoryTest.doTest();
		this.exerciseBaseRepositoryTest.doTest();
		
		super.doTest(this.exerciseLevelBaseRepository);
		
	}

}
