package ar.com.masch.exercise.learning.repository;

import java.util.List;

import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;
import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

public interface ExerciseBaseRepository extends BaseRepository<ExerciseBaseEntity, Long> {
	
	public ExerciseBaseEntity findByName(String name);
	
	public List<ExerciseBaseEntity> findByLevelBaseEntityOrderByNameAsc(LevelBaseEntity levelBaseEntity);

}
