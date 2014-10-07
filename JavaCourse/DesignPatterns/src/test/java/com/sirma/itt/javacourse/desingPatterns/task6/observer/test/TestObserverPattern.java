package com.sirma.itt.javacourse.desingPatterns.task6.observer.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.observation.Item;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.observation.ItemsInStock;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.observation.ItemsOutOfStock;

/**
 * Test classes in the package observation.
 * 
 * @author Simeon Iliev
 */
public class TestObserverPattern {

	private ItemsInStock stock;
	private ItemsOutOfStock orderLIst;
	private Item itemOne;
	private Item itemTwo;
	private Item itemThree;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		stock = new ItemsInStock();
		orderLIst = new ItemsOutOfStock();
		itemOne = new Item("sirene");
		itemTwo = new Item("kaskaval");
		itemThree = new Item("mlqko");
		itemOne.addObserver(stock);
		itemTwo.addObserver(stock);
		itemThree.addObserver(stock);
		itemOne.addObserver(orderLIst);
		itemTwo.addObserver(orderLIst);
		itemThree.addObserver(orderLIst);
		itemOne.deliverItem();
		itemTwo.deliverItem();
		itemThree.deliverItem();
	}

	/**
	 * Test if an item is in stock.
	 */
	@Test
	public void testInStockTrue() {
		assertTrue(itemOne.isInStock());
	}

	/**
	 * Test sell item.
	 */
	@Test
	public void testSellItem() {
		itemOne.sellItem();
		assertFalse(itemOne.isInStock());
	}

	/**
	 * Test sell item.
	 */
	@Test
	public void testItemCountInStockList() {
		assertEquals(3, stock.getItemsInStock().size());
	}

	/**
	 * Test sell item.
	 */
	@Test
	public void testItemCountInOrderList() {
		assertEquals(0, orderLIst.getItemsOutOfStock().size());
	}
}
