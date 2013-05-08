package ar.com.masch.exercise.learning.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public abstract class CRUDRepositoryBaseTest<T> {
	
	protected List<T> elementsSamples = new ArrayList<T>();
	protected List<T> elementsCreated = new ArrayList<T>();
	protected List<T> elementsSearched = new ArrayList<T>();
	
	public abstract void fillElementsSamples();
	public abstract void searchElements();
	public abstract void assertValues(T obj1, T obj2);
	
	public void doTest(CrudRepository<T, Long> repository) {
		
		this.fillElementsSamples();
		this.createElments(repository);
		this.fillElementsSamples();
		this.searchElements();
		this.assertElements();
		
	}
	
	public void createElments(CrudRepository<T, Long> repository) {
		
		for (T authorEntity : this.elementsSamples) {
			T authorEntityCreated = repository.save(authorEntity);
			assertNotNull(authorEntityCreated);
			this.elementsCreated.add(authorEntityCreated);
		}

	}
	
	public void assertElements() {
		
		for (int i = 0; i < this.elementsSamples.size(); i++) {
			assertValues(this.elementsSamples.get(i),
					     this.elementsCreated.get(i));
			
			assertValues(this.elementsSamples.get(i),
					     this.elementsSearched.get(i));
		}
		
	}

}
