package com.sirma.itt.javacourse.desingPatterns.task6.observer.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.Inventory;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.Item;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.StockObserver;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.StockObserverImpl;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.StockToOrder;

/**
 * @author Simeon Iliev
 */
public class TestStockObserver {

	private StockObserver observer;
	private Inventory inventory;
	private StockToOrder orderList;
	private Item itemOne;
	private Item itemTwo;
	private Item itemThree;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		inventory = new Inventory();
		orderList = new StockToOrder();
		observer = new StockObserverImpl(inventory, orderList);
		itemOne = new Item("Chease");
		itemTwo = new Item("Cola");
		itemThree = new Item("Bread");
		observer.deliveryUpdate(itemOne);
		observer.deliveryUpdate(itemTwo);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.StockObserverImpl#deliveryUpdate(com.sirma.itt.javacourse.desingPatterns.task6.observer.Item)}
	 * .
	 */
	@Test
	public void testDeliveryUpdate() {
		observer.deliveryUpdate(itemThree);
		assertEquals(3, inventory.getInventory().size());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task6.observer.StockObserverImpl#purcheaseUpdate(com.sirma.itt.javacourse.desingPatterns.task6.observer.Item)}
	 * .
	 */
	@Test
	public void testPurcheaseUpdate() {
		observer.purcheaseUpdate(itemOne);
		assertEquals(1, orderList.getOutOfStockItems().size());
	}

}
