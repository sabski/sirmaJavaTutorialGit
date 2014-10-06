package com.sirma.itt.javacourse.desingPatterns.task6.observer.observation;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.sirma.itt.javacourse.IOUtils;

/**
 * @author Simeon Iliev
 */
public class ItemsInStock implements Observer {

	private List<Observable> itemsInStock;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg) {
		IOUtils.printConsoleMessage("update");
		if (!(o instanceof Item)) {
			return;
		}
		Item temp = (Item) o;
		if (temp.isInStock()) {
			itemsInStock.add(o);
		} else {
			if (itemsInStock.contains(o)) {
				itemsInStock.remove(o);
			}
		}
	}

	/**
	 * Getter method for itemsInStock.
	 * 
	 * @return the itemsInStock
	 */
	public List<Observable> getItemsInStock() {
		return itemsInStock;
	}

	/**
	 * Setter method for itemsInStock.
	 * 
	 * @param itemsInStock
	 *            the itemsInStock to set
	 */
	public void setItemsInStock(List<Observable> itemsInStock) {
		this.itemsInStock = itemsInStock;
	}

	/**
	 * Basic Constructor.
	 */
	public ItemsInStock() {
		itemsInStock = new ArrayList<Observable>();
	}

}
