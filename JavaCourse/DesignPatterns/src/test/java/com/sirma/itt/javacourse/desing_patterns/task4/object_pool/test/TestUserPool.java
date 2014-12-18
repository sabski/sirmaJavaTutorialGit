package com.sirma.itt.javacourse.desing_patterns.task4.object_pool.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingpatterns.task4.objectpool.NoMoreResourcesException;
import com.sirma.itt.javacourse.desingpatterns.task4.objectpool.User;
import com.sirma.itt.javacourse.desingpatterns.task4.objectpool.UserPool;

/**
 * Test class for {@link UserPool}
 * 
 * @author Simeon Iliev
 */
public class TestUserPool {

	private static Logger log = Logger.getLogger(TestUserPool.class.getName());
	private UserPool<User> pool;

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
	 * {@link com.sirma.itt.javacourse.desingpatterns.task4.objectpool.UserPool#acquire()}.
	 * 
	 * @throws NoMoreResourcesException
	 */
	@Test
	public void testAquareUser() throws NoMoreResourcesException {
		User user = pool.acquire();
		assertTrue(user instanceof User);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task4.objectpool.UserPool#acquire()}.
	 * 
	 * @throws NoMoreResourcesException
	 */
	@Test
	public void testAquareUserException() {
		User userOne = null, userTwo = null, userThree = null, userFour = null, userFive = null;
		try {
			userOne = pool.acquire();
			userTwo = pool.acquire();
			userThree = pool.acquire();
			userFour = pool.acquire();
			userFive = pool.acquire();
			pool.acquire();
		} catch (NoMoreResourcesException e) {
			assertTrue(e instanceof NoMoreResourcesException);
		} finally {
			try {
				pool.release(userOne);
				pool.release(userTwo);
				pool.release(userThree);
				pool.release(userFour);
				pool.release(userFive);
			} catch (NoMoreResourcesException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task4.objectpool.UserPool#releseUser(com.sirma.itt.javacourse.desingpatterns.task4.objectpool.User)}
	 * .
	 */
	@Test
	public void testReleseUser() {
		try {
			User user = pool.acquire();
			pool.release(user);
		} catch (NoMoreResourcesException e) {
			log.error(e.getMessage(), e);
		}

	}

}
