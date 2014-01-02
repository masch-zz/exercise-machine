package ar.com.masch.exercise.learning;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.masch.exercise.learning.service.RoutineService;
import ar.com.masch.exercise.learning.dto.exercise.RoutineDTO;
import ar.com.masch.exercise.learning.dto.exercise.RoutineExerciseDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercises-application-context.xml")
public class RoutineServiceTest {
	
	@Resource
	private RoutineService routineService;
	
	@Resource
	private RoutineDTO routine1y1;
	
	private void assertRoutineExerciseDTO(RoutineExerciseDTO source, RoutineExerciseDTO destiny) {
		
		Assert.assertNotNull(source);
		Assert.assertNotNull(destiny);
		Assert.assertNotEquals(source, destiny);
		Assert.assertEquals(source.getName(), destiny.getName());
		Assert.assertEquals(source.getLevel(), destiny.getLevel());
		Assert.assertEquals(source.getIndex(), destiny.getIndex());
		Assert.assertEquals(source.getChapter(), destiny.getChapter());
		Assert.assertEquals(source.getVelocity(), destiny.getVelocity());
		Assert.assertEquals(source.getSoundFileName(), destiny.getSoundFileName());
		Assert.assertEquals(source.getPatternFileName(), destiny.getPatternFileName());
		
	}
	
	private void assertRoutineDTO(RoutineDTO routineDTO) {
		
		RoutineDTO routineSearchedDTO = this.routineService.getRoutine(routineDTO.getName());
		
		Assert.assertNotNull(routineSearchedDTO);
		Assert.assertEquals(routineSearchedDTO.getName(), routineDTO.getName());
		Assert.assertEquals(routineSearchedDTO.getRoutineExerciseDTOList().size(), routineDTO.getRoutineExerciseDTOList().size());		
		
		for (int i = 0 ; i < routineDTO.getRoutineExerciseDTOList().size(); i++) {
			assertRoutineExerciseDTO(routineDTO.getRoutineExerciseDTOList().get(i),
									 routineSearchedDTO.getRoutineExerciseDTOList().get(i));
		}
		
	}
	
	@Test
	public void test1() {
		
		assertRoutineDTO(routine1y1);

	}
	
}
