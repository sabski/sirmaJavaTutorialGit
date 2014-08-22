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
		// LRUCache cache = new LRUCache(150);
		LRUMapCache<Integer, Integer> mapCache = new LRUMapCache<Integer, Integer>(100);
		LRUTailCache<Integer, Integer> tailCache = new LRUTailCache<Integer, Integer>(100);

		for (int i = 0; i < 100220; i++) {
			Integer tmp = Utils.generateRandomNumberWithRange(1, 500);
			Utils.printConsoleMessage("Random generated number " + tmp);
			// cache.addCacheEllement(tmp);
			// mapCache.addCacheEllement(tmp, tmp);
			tailCache.addElement(tmp, tmp);
		}

		// Utils.printConsoleMessage(cache.getAllEllements().toString());
		// Utils.printConsoleMessage(cache.getAllEllements().size() + "");

		// Utils.printConsoleMessage(mapCache.getAllElements().toString());
		// Utils.printConsoleMessage(mapCache.getAllElements().size() + "");
		Utils.printConsoleMessage(tailCache.getAllElements().toString());
		Utils.printConsoleMessage(tailCache.getAllElements().size() + "");

	}

}
