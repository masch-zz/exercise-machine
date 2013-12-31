package ar.com.masch.exercise.learning.repository.base;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.repository.AuthorRepository;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;

public class AuthorRepositoryTest extends CRUDRepositoryBaseTest<AuthorEntity> {

	@Autowired
	private AuthorRepository authorRepository;	

	@Override
	public void fillElementsSamples() {
		
		ArrayList<AuthorEntity> elementsSamples = new ArrayList<AuthorEntity>();

		for (int i = 0; i < 5; ++i) {
			elementsSamples.add(new AuthorEntity(null, "authorName" + i, "authorLastName" + i, "authorFirstName" + i, "authorMiddleName" + i));
		}
		
		this.addSamples(elementsSamples);
		this.addSamples(elementsSamples);

	}

	@Override
	public void searchElements() {

		ArrayList<AuthorEntity> elementsSearchedByName = new ArrayList<AuthorEntity>();
		ArrayList<AuthorEntity> elementsSearchedByLastName = new ArrayList<AuthorEntity>();
		
		for (AuthorEntity authorEntity : this.getElementsSamples()) {
			//Find By Name
			AuthorEntity elementSearchedByName = this.authorRepository.findByName(authorEntity.getName());
			assertNotNull(elementSearchedByName);
			elementsSearchedByName.add(elementSearchedByName);
			
			//Find By Last Name
			AuthorEntity elementSearchedByLastName = this.authorRepository.findByLastName(authorEntity.getLastName());
			assertNotNull(elementSearchedByLastName);
			elementsSearchedByLastName.add(elementSearchedByLastName);
		}
		
		this.addSearched(elementsSearchedByName);
		this.addSearched(elementsSearchedByLastName);

	}
	
	@Override
	public void assertValues(AuthorEntity obj1, AuthorEntity obj2) {

		super.assertNotEqualsValuesBase(obj1, obj2);
		
		//assertEquals(obj1.getId(), obj2.getId());
		assertEquals(obj1.getName(), obj2.getName());
		assertEquals(obj1.getLastName(), obj2.getLastName());
		assertEquals(obj1.getFirstName(), obj2.getFirstName());
		assertEquals(obj1.getMiddleName(), obj2.getMiddleName());
		
	}
	
	//@Test
	public void doTest() {

		super.doTest(this.authorRepository);

	}

}
