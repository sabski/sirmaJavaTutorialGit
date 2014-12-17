package com.sirma.itt.javacourse.threads.test.task6;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task6.timeouthashtable.TimeoutHashtable;

/**
 * Test for {@link TimeoutHashtable}
 * 
 * @author Simeon Iliev
 */
public class TestTimeoutTable {

	private TimeoutHashtable table;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		table = new TimeoutHashtable(1000);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.threads.task6.timeouthashtable.TimeoutHashtable#put(java.lang.String, java.lang.Object)}
	 * .
	 */
	@Test
	public void testPut() {
		assertEquals(null, table.put("5", 5));
		assertEquals(5, table.put("5", 4));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.threads.task6.timeouthashtable.TimeoutHashtable#get(java.lang.String)}
	 * .
	 */
	@Test
	public void testGet() {
		table.put("5", 5);
		assertEquals(5, table.get("5"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.threads.task6.timeouthashtable.TimeoutHashtable#remove(java.lang.String)}
	 * .
	 */
	@Test
	public void testRemove() {
		table.put("5", 5);
		assertEquals(5, table.remove("5"));
	}

}
