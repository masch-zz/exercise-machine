package ar.com.masch.exercise.learning.repository.base;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;
import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;
import ar.com.masch.exercise.learning.repository.ExerciseBaseRepository;

public class ExerciseBaseRepositoryTest extends CRUDRepositoryBaseTest<ExerciseBaseEntity> {

	@Autowired
	private ExerciseBaseRepository exerciseBaseRepository;

	@Autowired
	private LevelBaseRepositoryTest levelBaseRepositoryTest;
	
	private LevelBaseEntity levelBaseEntity1;
	private LevelBaseEntity levelBaseEntity2;
	
	
	@Override
	public void fillElementsSamples() {
		
		this.levelBaseEntity1 = this.levelBaseRepositoryTest.getElementsCreated().get(0);
		this.levelBaseEntity2 = this.levelBaseRepositoryTest.getElementsCreated().get(1);
		
		this.elementsSamples.add(new ExerciseBaseEntity(null, "exerciseBaseName1", this.levelBaseEntity1));
		this.elementsSamples.add(new ExerciseBaseEntity(null, "exerciseBaseName2", this.levelBaseEntity2));
		
	}

	@Override
	public void searchElements() {
		
		ArrayList<ExerciseBaseEntity> elementsSearchedByName = new ArrayList<ExerciseBaseEntity>();
		ArrayList<ExerciseBaseEntity> elementsSearchedByLevel = new ArrayList<ExerciseBaseEntity>();
		
		for (ExerciseBaseEntity exerciseBaseEntity : this.elementsSamples) {
			//Find By Name
			ExerciseBaseEntity exerciseBaseEntityFindByName = this.exerciseBaseRepository.findByName(exerciseBaseEntity.getName());
			assertNotNull(exerciseBaseEntityFindByName);
			elementsSearchedByName.add(exerciseBaseEntityFindByName);
			
			//Find By Level
			ExerciseBaseEntity exerciseBaseEntityFindByLevel = this.exerciseBaseRepository.findByLevelBaseEntity(exerciseBaseEntity.getLevelBaseEntity());
			assertNotNull(exerciseBaseEntityFindByLevel);
			elementsSearchedByLevel.add(exerciseBaseEntityFindByLevel);
		}
		
		this.elementsSearched.add(elementsSearchedByName);
		this.elementsSearched.add(elementsSearchedByLevel);
		
	}

	@Override
	public void assertValues(ExerciseBaseEntity obj1, ExerciseBaseEntity obj2) {
		super.assertNotEqualsValuesBase(obj1, obj2);
		
		//assertEquals(obj1.getId(), obj2.getId());
		assertEquals(obj1.getName(), obj2.getName());

		this.levelBaseRepositoryTest.assertEqualsValuesBase(obj1.getLevelBaseEntity(), obj2.getLevelBaseEntity());
		
	}

	@Test
	public void doTest() {

		this.levelBaseRepositoryTest.doTest();
		super.doTest(this.exerciseBaseRepository);

	}	
	
}
