package ar.com.masch.exercise.learning.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;

@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercise-repository-test-context.xml")
public class AuthorCRUDRepositoryTestImpl extends CRUDRepositoryBaseTest<AuthorEntity> {

	@Autowired
	private AuthorRepository authorRepository;	
	
	
	@Override
	public void fillElementsSamples() {

		this.elementsSamples.clear();
		this.elementsSamples.add(new AuthorEntity(null, "authorName1", "authorLastName1", "authorFirstName1", "authorMiddleName1"));
		this.elementsSamples.add(new AuthorEntity(null, "authorName2", "authorLastName2", "authorFirstName2", "authorMiddleName2"));

	}

	@Override
	public void searchElements() {
		
		for (AuthorEntity authorEntity : elementsSamples) {
			AuthorEntity authorEntitySearched = this.authorRepository.findByName(authorEntity.getName());
			assertNotNull(authorEntitySearched);
			this.elementsSearched.add(authorEntitySearched);
		}
		
	}
	
	@Override
	public void assertValues(AuthorEntity obj1, AuthorEntity obj2) {
		assertNotNull(obj1);
		assertNotNull(obj2);
		
		assertNotEquals(obj1, obj2);
		
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
