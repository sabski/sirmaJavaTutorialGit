package com.sirma.itt.javacourse.desingpatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Order list for items that went out of stock.
 * 
 * @author Simeon Iliev
 */
public class OrderObesrver implements Observer {

	private final List<Observable> list;

	@Override
	public void update(Observable observable) {
		if (!(observable instanceof ItemObservable)) {
			return;
		}
		ItemObservable observableItem = (ItemObservable) observable;
		if (!observableItem.getInStock()) {
			list.add(observable);
		} else if (list.contains(observable)) {
			list.remove(observable);
		}
	}

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
