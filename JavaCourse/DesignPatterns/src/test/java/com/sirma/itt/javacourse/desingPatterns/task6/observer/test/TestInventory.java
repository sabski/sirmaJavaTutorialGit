package com.sirma.itt.javacourse.desingPatterns.task6.observer.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.Inventory;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.Item;

/**
 * Test class for {@link Inventory}
 * 
 * @author Simeon Iliev
 */
public class TestInventory {

	private Inventory inventory;
	private Item itemOne;
	private Item itemTwo;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		inventory = new Inventory();
		itemOne = new Item("Chio chips");
		itemTwo = new Item("Bread");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.Inventory#deliverdItems(com.sirma.itt.javacourse.desingPatterns.task6.observer.Item)}
	 * .
	 */
	@Test
	public void testDeliverdItems() {
		inventory.deliverdItems(itemOne);
		assertTrue(inventory.getInventory().contains(itemOne));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.Inventory#sellItems(com.sirma.itt.javacourse.desingPatterns.task6.observer.Item)}
	 * .
	 */
	@Test
	public void testSellItems() {
		inventory.deliverdItems(itemTwo);
		inventory.sellItems(itemTwo);
		assertFalse(inventory.getInventory().contains(itemTwo));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.Inventory#printInventory()}.
	 */
	@Test
	public void testPrintInventory() {
		String result = "0: Bread";
		inventory.deliverdItems(itemTwo);
		assertEquals(result, inventory.printInventory());
	}

}
