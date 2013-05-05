package ar.com.masch.exercise.learning.repository;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;

@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercise-repository-test-context.xml")
public class AuthorRepositoryTest {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorCRUDRepositoryTestImpl authorCRUDRepositoryTest;
	
	@Test
	public void testFind() {
		
		//Creo un elemento
		AuthorEntity authorEntityCreated1 = this.authorCRUDRepositoryTest.getNewElement(authorCRUDRepositoryTest.authorEntityName1.getName());
		assertNull(authorEntityCreated1.getId());
		this.authorRepository.save(authorEntityCreated1);
		assertNotNull(authorEntityCreated1);
		assertNotNull(authorEntityCreated1.getId());


		//Creo otro elemento
		AuthorEntity authorEntityCreated2 = this.authorCRUDRepositoryTest.getNewElement(authorCRUDRepositoryTest.authorEntityName2.getName());
		assertNull(authorEntityCreated2.getId());
		authorEntityCreated2 = this.authorRepository.saveAndFlush(authorEntityCreated2);
		assertNotNull(authorEntityCreated2);
		assertNotNull(authorEntityCreated2.getId());
		
		
		//Busco el primer elemento y lo comparo con el modelo del primer elemento
		AuthorEntity authorEntitySearched1 = this.authorRepository.findByName(authorCRUDRepositoryTest.authorEntityName1.getName().toString());
		assertNotNull(authorEntitySearched1);
		assertTrue(authorEntityCreated1.equals(authorEntitySearched1));
		

		//Busco el segundo elemento y lo comparo con el modelo del segundo elemento
		AuthorEntity authorEntitySearched2 = this.authorRepository.findByName(authorCRUDRepositoryTest.authorEntityName2.getName().toString());
		assertNotNull(authorEntitySearched2);
		assertTrue(authorEntityCreated2.equals(authorEntitySearched2));
		
		
		//Comparo los valores entre el primero modelo y el primero encontrado
		AuthorEntity authorEntityModel1 = this.authorCRUDRepositoryTest.getNewElement(authorCRUDRepositoryTest.authorEntityName1.getName());
		assertFalse(authorEntitySearched1.equals(authorEntityModel1));
		this.authorCRUDRepositoryTest.assertValues(authorEntityModel1, authorEntitySearched1);
		

		//Comparo los valores entre el primero modelo y el primero encontrado
		AuthorEntity authorEntityModel2 = this.authorCRUDRepositoryTest.getNewElement(authorCRUDRepositoryTest.authorEntityName2.getName());
		assertFalse(authorEntitySearched2.equals(authorEntityModel2));
		this.authorCRUDRepositoryTest.assertValues(authorEntityModel2, authorEntitySearched2);
		
	}
	
}
