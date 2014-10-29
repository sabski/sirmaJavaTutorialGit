package com.sirma.itt.javacourse.collections.task4.LRUcache;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.MathUtil;

/**
 * Runner class for {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache}
 * @author Simeon Iliev
 */
public class RunLRUCache {

	/**
	 * Main method for the application.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		LRUTailCache<Integer, Integer> tailCache = new LRUTailCache<Integer, Integer>(100);

		for (int i = 0; i < 100220; i++) {
			Integer randomNumber = MathUtil.generateRandomNumberWithRange(1, 500);
			IOUtils.printConsoleMessage("Random generated number " + randomNumber);
			tailCache.addElement(randomNumber, randomNumber);
		}
		IOUtils.printConsoleMessage(tailCache.getAllElements().toString());
		IOUtils.printConsoleMessage(tailCache.getAllElements().size() + "");

	}

}
