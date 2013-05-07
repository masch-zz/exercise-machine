package ar.com.masch.exercise.learning.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import ar.com.masch.exercise.learning.entity.base.AuthorEntity;

public class AuthorCRUDRepositoryTestImpl implements CRUDRepositoryTest<AuthorEntity> {

    public AuthorEntity authorEntityName1 = new AuthorEntity(null, "authorName1", "authorLastName1", "authorFirstName1", "authorMiddleName1");
    public AuthorEntity authorEntityName2 = new AuthorEntity(null, "authorName2", "authorLastName2", "authorFirstName2", "authorMiddleName2");
	
	@Override
	public AuthorEntity getNewElement(String key) {
		AuthorEntity temp = null;
		AuthorEntity result = null;	
		
		if (key.equals(authorEntityName1.getName())) {
			temp = authorEntityName1;
		}else if (key.equals(authorEntityName2.getName())) {
			temp = authorEntityName2;
		}
		
		if (temp != null) {
			result =  new AuthorEntity(temp.getId(), temp.getName(), temp.getLastName(), temp.getFirstName(), temp.getMiddleName());
		}
		
		return result;
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

}
