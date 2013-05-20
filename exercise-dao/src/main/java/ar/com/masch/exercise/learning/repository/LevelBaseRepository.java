package ar.com.masch.exercise.learning.repository;

import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;

public interface LevelBaseRepository extends BaseRepository<LevelBaseEntity, Long> {
	
	public LevelBaseEntity findByName(String name);

}
