package ar.com.masch.exercise.learning.repository;

import java.util.List;

import ar.com.masch.exercise.learning.entity.base.RoutineBaseEntity;
import ar.com.masch.exercise.learning.entity.base.RoutineExerciseBaseEntity;

public interface RoutineExerciseBaseRepository extends BaseRepository<RoutineExerciseBaseEntity, Long>{

	public List<RoutineExerciseBaseEntity> findByRoutineBaseEntityOrderByPositionOrderAsc(RoutineBaseEntity routineBaseEntity);
	
}
