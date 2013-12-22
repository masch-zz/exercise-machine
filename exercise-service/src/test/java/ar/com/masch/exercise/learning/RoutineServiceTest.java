package ar.com.masch.exercise.learning;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.masch.exercise.learning.dto.RoutineDTO;
import ar.com.masch.exercise.learning.service.RoutineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercises-application-context.xml")
public class RoutineServiceTest {
	
	@Resource
	RoutineService routineService;
	
	private void assertRoutineDTO(String name, int size) {
		
		RoutineDTO routineDTO = this.routineService.getRoutine(name);
		
		Assert.assertEquals(name, routineDTO.getName());
		Assert.assertEquals(size, routineDTO.getExerciseDTOList().size());		
	}
	
	@Test
	public void test1() {
		
		assertRoutineDTO("plWT1", 3);
		assertRoutineDTO("plWT2", 2);

	}
	
}
