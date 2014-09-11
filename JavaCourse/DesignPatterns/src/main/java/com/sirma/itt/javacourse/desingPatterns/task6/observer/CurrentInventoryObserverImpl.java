package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Concrete implementation of the observer.
 * 
 * @author Simeon Iliev
 */
public class CurrentInventoryObserverImpl implements StockObserver {

	private List<Item> itemsInstock = new ArrayList<Item>();

	@Override
	public void deliveryUpdate(Item observable) {
		if (!itemsInstock.contains(observable)) {
			itemsInstock.add(observable);
		}
		IOUtils.printConsoleMessage("Item delivered : " + observable.getName());
	}

	@Override
	public void purcheaseUpdate(Item observable) {
		itemsInstock.remove(observable);
		IOUtils.printConsoleMessage("Removing item from inventory observer ");
	}

}
