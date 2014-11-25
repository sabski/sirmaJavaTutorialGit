package com.sirma.itt.javacourse.desing_patterns.task6.observer.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desing_patterns.task6.observer.ItemObservable;
import com.sirma.itt.javacourse.desing_patterns.task6.observer.OrderObesrver;
import com.sirma.itt.javacourse.desing_patterns.task6.observer.StockObserver;

/**
 * Test {@link StockObserver}, {@link ItemObservable}
 * 
 * @author Simeon Iliev
 */
public class TestObserver {

	private StockObserver stock;
	private OrderObesrver order;
	private ItemObservable item, itemOne, itemTwo;
	private String result = "[sirene, kashkaval, mlqko]";

	/**
	 * Set up before method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		stock = new StockObserver();
		order = new OrderObesrver();
		item = new ItemObservable("sirene");
		itemOne = new ItemObservable("kashkaval");
		itemTwo = new ItemObservable("mlqko");
		item.attachObserver(stock);
		itemOne.attachObserver(stock);
		itemTwo.attachObserver(stock);
		item.attachObserver(order);
		itemOne.attachObserver(order);
		itemTwo.attachObserver(order);
		item.deliverItem();
		itemOne.deliverItem();
		itemTwo.deliverItem();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desing_patterns.task6.observer.StockObserver#update(com.sirma.itt.javacourse.desing_patterns.task6.observer.Observable)}
	 * .
	 */
	@Test
	public void testUpdate() {
		assertEquals(3, stock.getList().size());
	}

	/**
	 * Test if the list of the observer contains the write items.
	 */
	@Test
	public void testListResults() {
		assertEquals(result, stock.toString());
	}

	/**
	 * Test order list result.
	 */
	@Test
	public void testOrderList() {
		item.sellItem();
		itemOne.sellItem();
		itemTwo.sellItem();
		assertEquals(result, order.toString());
	}

	/**
	 * Test if an observer is detached.
	 */
	@Test
	public void DetachObserver() {
		item.dettachObserver(order);
		assertEquals(1, item.getObserverCount());
	}
}
