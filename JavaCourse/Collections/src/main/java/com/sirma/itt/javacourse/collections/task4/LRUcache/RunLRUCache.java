package com.sirma.itt.javacourse.collections.task4.LRUcache;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.MathUtil;

/**
 * @author simeon
 */
public class RunLRUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// LRUCache cache = new LRUCache(150);
		// LRUMapCache<Integer, Integer> mapCache = new LRUMapCache<Integer, Integer>(100);
		LRUTailCache<Integer, Integer> tailCache = new LRUTailCache<Integer, Integer>(100);

		for (int i = 0; i < 100220; i++) {
			Integer tmp = MathUtil.generateRandomNumberWithRange(1, 500);
			IOUtils.printConsoleMessage("Random generated number " + tmp);
			// cache.addCacheEllement(tmp);
			// mapCache.addCacheEllement(tmp, tmp);
			tailCache.addElement(tmp, tmp);
		}

		// IOUtils.printConsoleMessage(cache.getAllEllements().toString());
		// IOUtils.printConsoleMessage(cache.getAllEllements().size() + "");

		// IOUtils.printConsoleMessage(mapCache.getAllElements().toString());
		// IOUtils.printConsoleMessage(mapCache.getAllElements().size() + "");
		IOUtils.printConsoleMessage(tailCache.getAllElements().toString());
		IOUtils.printConsoleMessage(tailCache.getAllElements().size() + "");

	}

}
