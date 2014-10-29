package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Order list for items that went out of stock.
 * 
 * @author Simeon Iliev
 */
public class OrderObesrver implements Observer {

	private final List<Observable> list;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable observable) {
		if (!(observable instanceof ItemObservable)) {
			return;
		}
		ItemObservable temp = (ItemObservable) observable;
		if (!temp.getInStock()) {
			list.add(observable);
		} else if (list.contains(observable)) {
			list.remove(observable);
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
	public List<Observable> getList() {
		return list;
	}

	/**
	 * Constructor.
	 */
	public OrderObesrver() {
		list = new ArrayList<Observable>();
	}

}
