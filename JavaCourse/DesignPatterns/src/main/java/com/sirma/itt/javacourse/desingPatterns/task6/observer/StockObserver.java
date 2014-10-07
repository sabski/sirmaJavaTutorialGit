package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer that show the current items in stock.
 * 
 * @author Simeon Iliev
 */
public class StockObserver implements Observer {

	private List<Observerable> list;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observerable obs) {
		if (!(obs instanceof ItemObserverable)) {
			return;
		}
		ItemObserverable temp = (ItemObserverable) obs;
		if (temp.getInStock()) {
			list.add(obs);
		} else if (list.contains(obs)) {
			list.remove(obs);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return list.toString();
	}

	/**
	 * Getter method for list.
	 * 
	 * @return the list
	 */
	public List<Observerable> getList() {
		return list;
	}

	/**
	 * Constructor.
	 */
	public StockObserver() {
		list = new ArrayList<Observerable>();
	}

}
