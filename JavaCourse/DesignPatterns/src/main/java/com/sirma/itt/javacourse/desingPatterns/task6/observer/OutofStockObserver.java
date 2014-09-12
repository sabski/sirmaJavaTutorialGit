package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * @author Simeon Iliev
 */
public class OutofStockObserver implements StockObserver {

	private List<Item> itemsOutOfStock = new ArrayList<Item>();

	private Inventory inventory;
	private StockToOrder order;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deliveryUpdate(Item observable) {
		order.removeItem(observable);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void purcheaseUpdate(Item observable) {
		order.receiveItem(observable);
	}

}
