package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Item that is in a shop.
 * 
 * @author Simeon Iliev
 */
public class ItemObserverable implements Observerable {

	private List<Observer> observerList;
	private String name;
	private Boolean inStock;

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for inStock.
	 * 
	 * @return the inStock
	 */
	public Boolean getInStock() {
		return inStock;
	}

	/**
	 * Setter method for inStock.
	 * 
	 * @param inStock
	 *            the inStock to set
	 */
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
		notify(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void attachObserver(Observer obs) {
		observerList.add(obs);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dettachObserver(Observer obs) {
		if (observerList.contains(obs)) {
			observerList.remove(obs);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notify(Observerable obs) {
		for (Observer o : observerList) {
			o.update(obs);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getObserverCount() {
		return observerList.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            the name of the product.
	 */
	public ItemObserverable(String name) {
		this.name = name;
		observerList = new ArrayList<Observer>();
	}

	/**
	 * Deliver the item.
	 */
	public void deliverItem() {
		setInStock(true);
	}

	/**
	 * Sell the item.
	 */
	public void sellItem() {
		setInStock(false);
	}
}
