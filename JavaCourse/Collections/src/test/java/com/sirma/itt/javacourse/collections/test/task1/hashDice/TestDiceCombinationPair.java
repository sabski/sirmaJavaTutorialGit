package com.sirma.itt.javacourse.collections.test.task1.hashDice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.collections.task1.hashDice.DiceCombintionPair;

/**
 * JUnit test class for
 * {@link com.sirma.itt.javacourse.collections.task1.hashDice.DiceCombintionPair}
 * 
 * @author Simeon Iliev
 */
public class TestDiceCombinationPair {

	private DiceCombintionPair pairOne;
	private DiceCombintionPair pairtwo;

	/**
	 * Set up variables before each method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		pairOne = new DiceCombintionPair();
		pairtwo = new DiceCombintionPair();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task1.hashDice.DiceCombintionPair#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		pairOne.setPair(1, 2);
		assertEquals(12, pairOne.hashCode());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task1.hashDice.DiceCombintionPair#equals(java.lang.Object)}
	 * .
	 */
	@Test
	public void testEqualsObject() {
		pairOne.setPair(1, 2);
		pairtwo.setPair(2, 1);
		assertTrue(pairOne.equals(pairtwo));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task1.hashDice.DiceCombintionPair#equals(java.lang.Object)}
	 * .
	 */
	@Test
	public void testEqualsObjectFalseResult() {
		pairOne.setPair(1, 2);
		pairtwo.setPair(2, 2);
		assertFalse(pairOne.equals(pairtwo));
	}
}
