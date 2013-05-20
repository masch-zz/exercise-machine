package ar.com.masch.exercise.learning.repository;

import java.util.List;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercise-repository-test-context.xml")
public abstract class CRUDRepositoryBaseTest<T> {
	
	protected List<T> elementsSamples = new ArrayList<T>();
	protected List<T> elementsCreated = new ArrayList<T>();
	protected List<ArrayList<T>> elementsSearched = new ArrayList<ArrayList<T>>();
	
	public abstract void fillElementsSamples();
	public abstract void searchElements();
	public abstract void assertValues(T obj1, T obj2);
	
	public List<T> getElementsSamples() {
		return this.elementsSamples;
	}
	
	public List<T> getElementsCreated() {
		return this.elementsCreated;
	}
	
	public void doTest(CrudRepository<T, Long> repository) {
		
		this.elementsSamples.clear();
		this.fillElementsSamples();
		this.createElments(repository);
		//NOTA: Lo llamo 2 veces para que se creen otros objetos ejemplos.
		this.elementsSamples.clear();
		this.fillElementsSamples();
		this.searchElements();
		this.assertElements();
		
	}
	
	public void createElments(CrudRepository<T, Long> repository) {
		
		for (T element : this.elementsSamples) {
			T authorEntityCreated = repository.save(element);
			assertNotNull(authorEntityCreated);
			this.elementsCreated.add(authorEntityCreated);
		}

	}
	
	public void assertNotNullBase(T obj1, T obj2) {
		
		assertNotNull(obj1);
		assertNotNull(obj2);

	}
	
	public void assertNotEqualsValuesBase(T obj1, T obj2) {
		
		assertNotNullBase(obj1, obj2);
		assertNotEquals(obj1, obj2);

	}
	
	public void assertEqualsValuesBase(T obj1, T obj2) {
		
		assertNotNullBase(obj1, obj2);
		assertEquals(obj1, obj2);

	}
	
	public void assertElements() {
		
		for (int i = 0; i < this.elementsSamples.size(); i++) {
			assertValues(this.elementsSamples.get(i),
					     this.elementsCreated.get(i));
			
			for (int j = 0; j < this.elementsSearched.size(); j++) {
				ArrayList<T> arrayList = this.elementsSearched.get(j);
				
				assertValues(this.elementsSamples.get(i),
						     arrayList.get(i));
			}
		}
		
	}

}
