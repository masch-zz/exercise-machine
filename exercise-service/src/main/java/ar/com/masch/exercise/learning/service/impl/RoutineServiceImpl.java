package ar.com.masch.exercise.learning.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.service.RoutineService;
import ar.com.masch.exercise.learning.factory.RoutineDTOFactory;
import ar.com.masch.exercise.learning.repository.AuthorRepository;
import ar.com.masch.exercise.learning.entity.book.ChapterBookEntity;
import ar.com.masch.exercise.learning.entity.base.RoutineBaseEntity;
import ar.com.masch.exercise.learning.dto.exercise.RoutineDTO;
import ar.com.masch.exercise.learning.dto.exercise.RoutineExerciseDTO;
import ar.com.masch.exercise.learning.repository.RoutineBaseRepository;
import ar.com.masch.exercise.learning.factory.RoutineExerciseDTOFactory;
import ar.com.masch.exercise.learning.entity.base.ExerciseLevelBaseEntity;
import ar.com.masch.exercise.learning.entity.base.RoutineExerciseBaseEntity;
import ar.com.masch.exercise.learning.repository.book.ChapterBookRepository;
import ar.com.masch.exercise.learning.repository.RoutineExerciseBaseRepository;

public class RoutineServiceImpl implements RoutineService {

	@Autowired
	private RoutineBaseRepository routineBaseRepository;
	
	@Autowired
	private RoutineExerciseBaseRepository routineExeciseBaseRepository;
	
	@Autowired
	private ChapterBookRepository chapterBookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	public void setRoutineBaseRepository(RoutineBaseRepository routineBaseRepository) {
		this.routineBaseRepository = routineBaseRepository;
	}
	
	private RoutineDTO getRoutineDTO(RoutineBaseEntity routineBaseEntity, List<RoutineExerciseBaseEntity> routineExerciseBaseEntities) {
		RoutineDTO result = null;
		List<RoutineExerciseDTO> routineExerciseDTOList = new ArrayList<RoutineExerciseDTO>();
		
		for (RoutineExerciseBaseEntity routineExerciseBaseEntity : routineExerciseBaseEntities) {
			ExerciseLevelBaseEntity exerciseLevelBaseEntity = routineExerciseBaseEntity.getExerciseLevelBaseEntity();
			ChapterBookEntity chapterBookEntity = exerciseLevelBaseEntity.getChapterBookEntity();
				
			RoutineExerciseDTO routineExerciseDTO = RoutineExerciseDTOFactory.create(
					                                	exerciseLevelBaseEntity.getExerciseBaseEntity().getName(),
					                                	routineExerciseBaseEntity.getPositionOrder(),
					                                	exerciseLevelBaseEntity.getVelocity(),
					                                	exerciseLevelBaseEntity.getLevelBaseEntity().getName(),
					                                	chapterBookEntity.getName());
			
			routineExerciseDTOList.add(routineExerciseDTO);
		}
		
		result = RoutineDTOFactory.create(routineBaseEntity.getName(), routineExerciseDTOList);
		
		return result;
	}
	
	public RoutineDTO getRoutine(String name) {
		RoutineDTO result = null;
		
		RoutineBaseEntity routineBaseEntity = this.routineBaseRepository.findByName(name);
		if (routineBaseEntity != null) {

			List<RoutineExerciseBaseEntity> routineExerciseBaseEntities = this.routineExeciseBaseRepository.findByRoutineBaseEntityOrderByPositionOrderAsc(routineBaseEntity);
			result = getRoutineDTO(routineBaseEntity, routineExerciseBaseEntities);
			
		}

		return result;
	}

}
