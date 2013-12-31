package ar.com.masch.exercise.learning.repository.base;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.RoutineBaseEntity;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;
import ar.com.masch.exercise.learning.entity.base.ExerciseLevelBaseEntity;
import ar.com.masch.exercise.learning.entity.base.RoutineExerciseBaseEntity;
import ar.com.masch.exercise.learning.repository.RoutineExerciseBaseRepository;

public class RoutineExerciseBaseRespositoryTest extends CRUDRepositoryBaseTest<RoutineExerciseBaseEntity> {

	@Autowired
	private RoutineExerciseBaseRepository routineExerciseBaseRepository;
	
	@Autowired
	private RoutineBaseRepositoryTest routineBaseRepositoryTest;
	
	private RoutineBaseEntity routineBaseEntity1;
	//private RoutineBaseEntity routineBaseEntity2;
	
	@Autowired
	private ExerciseLevelBaseRepositoryTest exerciseLevelBaseRepositoryTest;
	
	private ExerciseLevelBaseEntity exerciseLevelBaseEntity1;
	private ExerciseLevelBaseEntity exerciseLevelBaseEntity2;
	
	@Override
	public void fillElementsSamples() {
		ArrayList<RoutineExerciseBaseEntity> elementsSamples = new ArrayList<RoutineExerciseBaseEntity>();
		
		List<RoutineBaseEntity> routineBaseEntities = this.routineBaseRepositoryTest.getElementsCreated();
		List<ExerciseLevelBaseEntity> exerciseLevelBaseEntities = this.exerciseLevelBaseRepositoryTest.getElementsCreated();
		
		this.routineBaseEntity1 = routineBaseEntities.get(0);
		//this.routineBaseEntity2 = routineBaseEntities.get(1);
		
		this.exerciseLevelBaseEntity1 = exerciseLevelBaseEntities.get(0);
		this.exerciseLevelBaseEntity2 = exerciseLevelBaseEntities.get(1);
		
		for (int i = 0; i < 5; ++i) {
			elementsSamples.add(new RoutineExerciseBaseEntity(null, routineBaseEntity1, exerciseLevelBaseEntity1, i));
			elementsSamples.add(new RoutineExerciseBaseEntity(null, routineBaseEntity1, exerciseLevelBaseEntity2, i));	
		}
		
		this.addSamples(elementsSamples);
		
	}

	@Override
	public void searchElements() {
		
		//Find By routineBaseEntity1
		ArrayList<RoutineExerciseBaseEntity> elementsSearchedByRoutineBaseEntity1 = (ArrayList<RoutineExerciseBaseEntity>) 
								             this.routineExerciseBaseRepository.findByRoutineBaseEntity(this.routineBaseEntity1);
		this.addSearched(elementsSearchedByRoutineBaseEntity1);
		
	}

	@Override
	public void assertValues(RoutineExerciseBaseEntity obj1, RoutineExerciseBaseEntity obj2) {
		
		super.assertNotEqualsValuesBase(obj1, obj2);
		this.routineBaseRepositoryTest.assertEqualsValuesBase(obj1.getRoutineBaseEntity(), obj2.getRoutineBaseEntity());
		this.exerciseLevelBaseRepositoryTest.assertEqualsValuesBase(obj1.getExerciseLevelBaseEntity(), obj2.getExerciseLevelBaseEntity());
		
		assertEquals(obj1.getPositionOrder(), obj2.getPositionOrder());

	}

	@Override
	public void doTest() {
		
		this.exerciseLevelBaseRepositoryTest.doTest();
		this.routineBaseRepositoryTest.doTest();
		super.doTest(this.routineExerciseBaseRepository);
		
	}

}
