package com.sirma.itt.javacourse.desingPatterns.task4.objectPool;

/**
 * Pool interface.
 * 
 * @param <T>
 *            Type parameter for the class.
 * @author Simeon Iliev
 */
public interface Pool<T> {

	/**
	 * Acquires a free instance of <T>.
	 * 
	 * @return the acquired value from the pool.
	 * @throws NoMoreResourcesException
	 *             If there are no more resources to be acquired.
	 */
	public T acquire() throws NoMoreResourcesException;

	/**
	 * Releases a specific object from the pool.
	 * 
	 * @param object
	 *            The object to be released from the pool.
	 */
	public void release(T object);

	/**
	 * Created a new object of <T>
	 * 
	 * @return the new instance.
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public T initObject() throws InstantiationException, IllegalAccessException;
}
