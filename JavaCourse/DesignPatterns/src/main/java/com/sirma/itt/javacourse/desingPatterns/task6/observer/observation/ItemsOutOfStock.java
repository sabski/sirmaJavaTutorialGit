package com.sirma.itt.javacourse.desingPatterns.task6.observer.observation;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Simeon Iliev
 */
public class ItemsOutOfStock implements Observer {

	/**
	 * Getter method for itemsOutOfStock.
	 *
	 * @return the itemsOutOfStock
	 */
	public List<Observable> getItemsOutOfStock() {
		return itemsOutOfStock;
	}

	/**
	 * Setter method for itemsOutOfStock.
	 *
	 * @param itemsOutOfStock the itemsOutOfStock to set
	 */
	public void setItemsOutOfStock(List<Observable> itemsOutOfStock) {
		this.itemsOutOfStock = itemsOutOfStock;
	}

	private List<Observable> itemsOutOfStock;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (!(o instanceof Item)) {
			return;
		}
		Item temp = (Item) o;
		if (!temp.isInStock()) {
			itemsOutOfStock.add(o);
		} else {
			if (itemsOutOfStock.contains(o)) {
				itemsOutOfStock.remove(o);
			}
		}
	}

	/**
	 * Basic Constructor.
	 */
	public ItemsOutOfStock() {
		itemsOutOfStock = new ArrayList<Observable>();
	}

}
