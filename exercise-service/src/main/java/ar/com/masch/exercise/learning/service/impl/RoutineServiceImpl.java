package ar.com.masch.exercise.learning.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.service.RoutineService;
import ar.com.masch.exercise.learning.dto.exercise.RoutineDTO;
import ar.com.masch.exercise.learning.factory.RoutineDTOFactory;
import ar.com.masch.exercise.learning.repository.AuthorRepository;
import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;
import ar.com.masch.exercise.learning.entity.book.ChapterBookEntity;
import ar.com.masch.exercise.learning.entity.base.RoutineBaseEntity;
import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;
import ar.com.masch.exercise.learning.dto.exercise.RoutineExerciseDTO;
import ar.com.masch.exercise.learning.repository.RoutineBaseRepository;
import ar.com.masch.exercise.learning.factory.RoutineExerciseDTOFactory;
import ar.com.masch.exercise.learning.entity.base.ExerciseLevelBaseEntity;
import ar.com.masch.exercise.learning.entity.base.RoutineExerciseBaseEntity;
import ar.com.masch.exercise.learning.repository.book.ChapterBookRepository;
import ar.com.masch.exercise.learning.repository.RoutineExerciseBaseRepository;

public class RoutineServiceImpl implements RoutineService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private RoutineBaseRepository routineBaseRepository;
	
	@Autowired
	private ChapterBookRepository chapterBookRepository;
	
	@Autowired
	private RoutineExerciseBaseRepository routineExeciseBaseRepository;

	public void setRoutineBaseRepository(RoutineBaseRepository routineBaseRepository) {
		this.routineBaseRepository = routineBaseRepository;
	}
	
	private RoutineDTO getRoutineDTO(RoutineBaseEntity routineBaseEntity, List<RoutineExerciseBaseEntity> routineExerciseBaseEntities) {
		RoutineDTO result = null;
		List<RoutineExerciseDTO> routineExerciseDTOList = new ArrayList<RoutineExerciseDTO>();
		
		for (RoutineExerciseBaseEntity routineExerciseBaseEntity : routineExerciseBaseEntities) {
			ExerciseLevelBaseEntity exerciseLevelBaseEntity = routineExerciseBaseEntity.getExerciseLevelBaseEntity();
			ExerciseBaseEntity exerciseBaseEntity = exerciseLevelBaseEntity.getExerciseBaseEntity();
			ChapterBookEntity chapterBookEntity = exerciseLevelBaseEntity.getChapterBookEntity();
			LevelBaseEntity levelBaseEntity = exerciseLevelBaseEntity.getLevelBaseEntity();
				
			RoutineExerciseDTO routineExerciseDTO = RoutineExerciseDTOFactory.create(
														exerciseBaseEntity.getName(),
					                                	routineExerciseBaseEntity.getPositionOrder(),
					                                	exerciseLevelBaseEntity.getVelocity(),
					                                	levelBaseEntity.getName(),
					                                	chapterBookEntity.getName(),
					                                	exerciseBaseEntity.getType(),
					                                	exerciseLevelBaseEntity.getSoundFileName(),
					                                	exerciseBaseEntity.getPatternFileName());
			
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
