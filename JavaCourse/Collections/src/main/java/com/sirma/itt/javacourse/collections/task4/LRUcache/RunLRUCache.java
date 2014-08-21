package com.sirma.itt.javacourse.collections.task4.LRUcache;

import com.sirma.itt.javacourse.Utils;

/**
 * @author simeon
 */
public class RunLRUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(150);

		for (int i = 0; i < 122000; i++) {
			Integer tmp = Utils.generateRandomNumberWithRange(1, 10000);
			Utils.printConsoleMessage("Random generated number " + tmp);
			cache.addCacheEllement(tmp);
		}

		Utils.printConsoleMessage(cache.getAllEllements().toString());
		Utils.printConsoleMessage(cache.getAllEllements().size() + "");
	}

}
