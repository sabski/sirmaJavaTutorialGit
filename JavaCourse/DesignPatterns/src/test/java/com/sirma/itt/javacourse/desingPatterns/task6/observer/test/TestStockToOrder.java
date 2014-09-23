package com.sirma.itt.javacourse.desingPatterns.task6.observer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.Item;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.StockToOrder;

/**
 * Test class for {@link StockToOrder}
 * 
 * @author Simeon Iliev
 */
public class TestStockToOrder {
	private StockToOrder order;
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
		order = new StockToOrder();
		itemOne = new Item("Chio chips");
		itemTwo = new Item("Bread");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.StockToOrder#receiveItem(com.sirma.itt.javacourse.desingPatterns.task6.observer.Item)}
	 * .
	 */
	@Test
	public void testReceiveItem() {
		order.receiveItem(itemOne);
		assertTrue(order.getOutOfStockItems().contains(itemOne));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.StockToOrder#removeItem(com.sirma.itt.javacourse.desingPatterns.task6.observer.Item)}
	 * .
	 */
	@Test
	public void testRemoveItem() {
		order.receiveItem(itemTwo);
		order.removeItem(itemTwo);
		assertFalse(order.getOutOfStockItems().contains(itemTwo));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.StockToOrder#printInventory()}.
	 */
	@Test
	public void testPrintInventory() {
		String result = "0: Bread";
		order.receiveItem(itemTwo);
		assertEquals(result, order.printInventory());
	}

}
