package com.sirma.itt.javacourse.desingPatterns.task4.objectPool.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
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
	private UserPool pool;

	/**
	 * Set up method.
	 * 
	 * @throws Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		pool = new UserPool<User>(new User());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task4.objectPool.UserPool#acquire()}.
	 * 
	 * @throws NoMoreResourcesException
	 */
	@Test
	public void testAquareUser() throws NoMoreResourcesException {
		User user = (User) pool.acquire();
		assertTrue(user instanceof User);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task4.objectPool.UserPool#acquire()}.
	 * 
	 * @throws NoMoreResourcesException
	 */
	@Test
	public void testAquareUserException() {
		User userOne = null, userTwo = null, userThree = null, userFour = null, userFive = null;
		try {
			userOne = (User) pool.acquire();
			userTwo = (User) pool.acquire();
			userThree = (User) pool.acquire();
			userFour = (User) pool.acquire();
			userFive = (User) pool.acquire();
			pool.acquire();
		} catch (NoMoreResourcesException e) {
			assertTrue(e instanceof NoMoreResourcesException);
		} finally {
			pool.release(userOne);
			pool.release(userTwo);
			pool.release(userThree);
			pool.release(userFour);
			pool.release(userFive);
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
			User user = (User) pool.acquire();
			pool.release(user);
		} catch (NoMoreResourcesException e) {
			log.error(e.getMessage(), e);
		}

	}

}
