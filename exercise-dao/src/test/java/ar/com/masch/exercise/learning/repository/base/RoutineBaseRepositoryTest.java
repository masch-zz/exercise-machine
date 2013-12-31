package ar.com.masch.exercise.learning.repository.base;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.RoutineBaseEntity;
import ar.com.masch.exercise.learning.repository.RoutineBaseRepository;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;

public class RoutineBaseRepositoryTest extends CRUDRepositoryBaseTest<RoutineBaseEntity> {

	@Autowired
	private RoutineBaseRepository routineBaseRepository;
	
	@Autowired
	private ExerciseLevelBaseRepositoryTest exerciseLevelBaseRepositoryTest;
	
	@Override
	public void fillElementsSamples() {

		ArrayList<RoutineBaseEntity> elementsSamples = new ArrayList<RoutineBaseEntity>();
		
		for (int i = 0; i < 5; ++i) {
			elementsSamples.add(new RoutineBaseEntity(null, "routineBaseName" + i));	
		}
		
		this.addSamples(elementsSamples);

	}

	@Override
	public void searchElements() {

		ArrayList<RoutineBaseEntity> elementsSearchedByName = new ArrayList<RoutineBaseEntity>();
		
		for (RoutineBaseEntity routineBaseEntity : this.getElementsSamples()) {
			//Find By Name
			RoutineBaseEntity elementSearchedByName = this.routineBaseRepository.findByName(routineBaseEntity.getName());
			assertNotNull(elementSearchedByName);
			elementsSearchedByName.add(elementSearchedByName);
		}
		
		this.addSearched(elementsSearchedByName);
		
	}

	@Override
	public void assertValues(RoutineBaseEntity obj1, RoutineBaseEntity obj2) {

		super.assertNotEqualsValuesBase(obj1, obj2);
		
		assertEquals(obj1.getName(), obj2.getName());

	}

	//@Test
	public void doTest() {

		this.exerciseLevelBaseRepositoryTest.doTest();
		super.doTest(this.routineBaseRepository);

	}
	
}
