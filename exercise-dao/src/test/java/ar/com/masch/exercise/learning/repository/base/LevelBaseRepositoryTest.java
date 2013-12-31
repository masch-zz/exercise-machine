package ar.com.masch.exercise.learning.repository.base;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.LevelBaseEntity;
import ar.com.masch.exercise.learning.repository.LevelBaseRepository;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;

public class LevelBaseRepositoryTest extends CRUDRepositoryBaseTest<LevelBaseEntity> {
	
	@Autowired
	private LevelBaseRepository levelBaseRepository;
	
	@Override
	public void fillElementsSamples() {

		ArrayList<LevelBaseEntity> elementsSamples = new ArrayList<LevelBaseEntity>();
		
		for (int i = 0; i < 6; ++i) {
			elementsSamples.add(new LevelBaseEntity(null, "levelBaseName" + i));
		}

		this.addSamples(elementsSamples);
		
	}

	@Override
	public void searchElements() {
		ArrayList<LevelBaseEntity> elementsSearchedByName = new ArrayList<LevelBaseEntity>();
		
		for (LevelBaseEntity levelBaseEntity : this.getElementsSamples()) {
			//Find By Name
			LevelBaseEntity elementSearchedByName = this.levelBaseRepository.findByName(levelBaseEntity.getName());
			assertNotNull(elementSearchedByName);
			elementsSearchedByName.add(elementSearchedByName);
		}
		
		this.addSearched(elementsSearchedByName);
	}

	@Override
	public void assertValues(LevelBaseEntity obj1, LevelBaseEntity obj2) {
		super.assertNotEqualsValuesBase(obj1, obj2);
		
		//assertEquals(obj1.getId(), obj2.getId());
		assertEquals(obj1.getName(), obj2.getName());
	}
	
	//@Test
	public void doTest() {
		
		super.doTest(this.levelBaseRepository);

	}

}
