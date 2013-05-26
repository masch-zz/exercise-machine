package ar.com.masch.exercise.learning.repository;

import ar.com.masch.exercise.learning.entity.base.RoutineBaseEntity;

public interface RoutineBaseRepository extends BaseRepository<RoutineBaseEntity, Long> {
	
	public RoutineBaseEntity findByName(String name);

}
