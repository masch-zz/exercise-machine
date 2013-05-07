package ar.com.masch.exercise.learning.repository;

public interface CRUDRepositoryTest<T> {
	
	public T getNewElement(String key);

	public void assertValues(T obj1, T obj2);
}
