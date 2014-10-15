package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

import java.util.List;

/**
 * This class stores product units and sell them to consumers.
 * 
 * @author Simeon Iliev
 */
public class Warehouse {

	private List<AbstractProduct> products;

	public void createNewProduct(AbstractProduct product) {
		products.add(product);
	}

	public synchronized void deliverProduct(AbstractProduct product, int quantity) {
		if (products.contains(product)) {
			for (AbstractProduct pr : products) {
				if (pr.equals(product)) {
					pr.setQuantity(quantity + pr.getQuantity());
					pr.notify();
					break;
				}
			}
		}
	}
	
	public synchronized void sellItem(AbstractProduct product , int quantity){
		
	}
}
