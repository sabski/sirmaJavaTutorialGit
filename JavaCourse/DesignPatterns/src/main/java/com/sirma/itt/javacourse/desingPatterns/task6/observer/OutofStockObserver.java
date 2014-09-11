package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * @author Simeon Iliev
 */
public class OutofStockObserver implements StockObserver {

	private List<Item> itemsOutOfStock = new ArrayList<Item>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deliveryUpdate(Item observable) {
		if (itemsOutOfStock.contains(observable)) {
			itemsOutOfStock.remove(observable);
			IOUtils.printConsoleMessage("Item is removed from out of stock list");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void purcheaseUpdate(Item observable) {
		itemsOutOfStock.add(observable);
		IOUtils.printConsoleMessage("Item is out of stock" + observable.getName());
	}

}
