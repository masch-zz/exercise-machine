package ar.com.masch.exercise.learning.repository.base;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;
import ar.com.masch.exercise.learning.repository.AuthorRepository;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;

public class AuthorRepositoryTestImpl extends CRUDRepositoryBaseTest<AuthorEntity> {

	@Autowired
	private AuthorRepository authorRepository;	

	@Override
	public void fillElementsSamples() {

		this.elementsSamples.add(new AuthorEntity(null, "authorName1", "authorLastName1", "authorFirstName1", "authorMiddleName1"));
		this.elementsSamples.add(new AuthorEntity(null, "authorName2", "authorLastName2", "authorFirstName2", "authorMiddleName2"));

	}

	@Override
	public void searchElements() {

		ArrayList<AuthorEntity> elementsSearchedByName = new ArrayList<AuthorEntity>();
		ArrayList<AuthorEntity> elementsSearchedByLastName = new ArrayList<AuthorEntity>();
		
		for (AuthorEntity authorEntity : this.elementsSamples) {
			//Find By Name
			AuthorEntity authorEntitySearchedByName = this.authorRepository.findByName(authorEntity.getName());
			assertNotNull(authorEntitySearchedByName);
			elementsSearchedByName.add(authorEntitySearchedByName);
			
			//Find By Last Name
			AuthorEntity authorEntitySearchedByLastName = this.authorRepository.findByLastName(authorEntity.getLastName());
			assertNotNull(authorEntitySearchedByLastName);
			elementsSearchedByLastName.add(authorEntitySearchedByLastName);
		}
		
		this.elementsSearched.add(elementsSearchedByName);
		this.elementsSearched.add(elementsSearchedByLastName);

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
	
	@Test
	public void doTest() {

		super.doTest(this.authorRepository);

	}

}
