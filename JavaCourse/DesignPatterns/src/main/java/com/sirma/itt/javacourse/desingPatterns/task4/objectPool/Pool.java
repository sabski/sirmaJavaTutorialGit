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
	 * @throws NoMoreResourcesException
	 *             if there are no more recourses to be released.
	 */
	public void release(T object) throws NoMoreResourcesException;

	/**
	 * Created a new object of <T>
	 * 
	 * @return the new instance, or null if there was an exception in creating the object.
	 */
	public T initObject();
}
