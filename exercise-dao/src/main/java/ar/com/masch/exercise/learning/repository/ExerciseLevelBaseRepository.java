package ar.com.masch.exercise.learning.repository;

import java.util.List;

import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;
import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;
import ar.com.masch.exercise.learning.entity.base.ExerciseLevelBaseEntity;

public interface ExerciseLevelBaseRepository extends BaseRepository<ExerciseLevelBaseEntity, Long> {

	public List<ExerciseLevelBaseEntity> findByLevelBaseEntity(LevelBaseEntity levelBaseEntity);
	
	public List<ExerciseLevelBaseEntity> findByExerciseBaseEntity(ExerciseBaseEntity exerciseBaseEntity);
	
}
