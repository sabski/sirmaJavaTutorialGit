package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Stock Observer implementation.
 * 
 * @author Simeon Iliev
 */
public class StockObserverImpl implements StockObserver {

	private Inventory inventory;
	private StockToOrder order;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deliveryUpdate(Item observable) {
		order.removeItem(observable);
		inventory.deliverdItems(observable);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void purcheaseUpdate(Item observable) {
		order.receiveItem(observable);
		inventory.sellItems(observable);
	}

	/**
	 * Constructor that accepts 
	 * @param inventory
	 *            the inventory we want to notify
	 * @param order
	 *            the order list we want to notify
	 */
	public StockObserverImpl(Inventory inventory, StockToOrder order) {
		this.inventory = inventory;
		this.order = order;
	}

}
