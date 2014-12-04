package com.sirma.itt.javacourse.collections.test.task4.LRUTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache;

/**
 * Test the LRU algorithm tail implementation.
 * 
 * @author simeon
 */
public class TestLRUTailCache {

	private LRUTailCache<Integer, String> cache;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cache = new LRUTailCache<Integer, String>(4);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#addElement(java.lang.Object, java.lang.Object)}
	 * .
	 */
	@Test
	public void testAddElement() {
		assertTrue(cache.addElement(1, "one"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#getElement(java.lang.Object)}
	 * .
	 */
	@Test
	public void testGetElement() {
		String object = "MyObject";
		cache.addElement(2, object);
		assertEquals(object, cache.getElement(2));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#getElement(java.lang.Object)}
	 * .
	 */
	@Test
	public void testGetElementNull() {
		assertEquals(null, cache.getElement(20));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#removeElementByKey(java.lang.Object)}
	 * .
	 */
	@Test
	public void testRemoveElementByKey() {
		cache.addElement(1, "one");
		assertTrue(cache.removeElementByKey(1));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#removeElementByKey(java.lang.Object)}
	 * .
	 */
	@Test
	public void testRemoveElementByKeyNoKeyFound() {
		assertFalse(cache.removeElementByKey(100));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#getAllElements()}.
	 */
	@Test
	public void testGetAllElements() {
		Collection<String> result = Arrays.asList("uno", "dos", "thres");
		cache.addElement(1, "uno");
		cache.addElement(2, "dos");
		cache.addElement(3, "thres");
		assertArrayEquals(result.toArray(), cache.getAllElements().toArray());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task4.LRUcache.LRUTailCache#getAllElements()}.
	 */
	@Test
	public void testGetAllElementsLongSet() {
		Collection<String> result = Arrays.asList("dos", "thres", "quatro", "five");
		cache.addElement(1, "uno");
		cache.addElement(2, "dos");
		cache.addElement(3, "thres");
		cache.addElement(4, "quatro");
		cache.addElement(5, "five");
		assertArrayEquals(result.toArray(), cache.getAllElements().toArray());
	}

}
