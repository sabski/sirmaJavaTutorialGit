package com.sirma.itt.javacourse.desingPatterns.task4.objectPool.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task4.objectPool.NoMoreResourcesException;
import com.sirma.itt.javacourse.desingPatterns.task4.objectPool.User;
import com.sirma.itt.javacourse.desingPatterns.task4.objectPool.UserPool;

/**
 * Test class for {@link UserPool}
 * 
 * @author Simeon Iliev
 */
public class TestUserPool {

	private static Logger log = Logger.getLogger(TestUserPool.class.getName());
	private UserPool pool = UserPool.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task4.objectPool.UserPool#acquireUser()}.
	 * 
	 * @throws NoMoreResourcesException
	 */
	@Test
	public void testAquareUser() throws NoMoreResourcesException {
		User user = pool.acquireUser();
		assertTrue(user instanceof User);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task4.objectPool.UserPool#acquireUser()}.
	 * 
	 * @throws NoMoreResourcesException
	 */
	@Test
	public void testAquareUserException() {
		User userOne = null, userTwo = null, userThree = null, userFour = null, userFive = null;
		try {
			userOne = pool.acquireUser();
			userTwo = pool.acquireUser();
			userThree = pool.acquireUser();
			userFour = pool.acquireUser();
			userFive = pool.acquireUser();
			pool.acquireUser();
		} catch (NoMoreResourcesException e) {
			assertTrue(e instanceof NoMoreResourcesException);
		} finally {
			pool.releseUser(userOne);
			pool.releseUser(userTwo);
			pool.releseUser(userThree);
			pool.releseUser(userFour);
			pool.releseUser(userFive);
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task4.objectPool.UserPool#releseUser(com.sirma.itt.javacourse.desingPatterns.task4.objectPool.User)}
	 * .
	 */
	@Test
	public void testReleseUser() {
		try {
			User user = pool.acquireUser();
			pool.releseUser(user);
		} catch (NoMoreResourcesException e) {
			log.error(e.getMessage(), e);
		}

	}

}
