package com.sirma.itt.javacourse.collections.test.task2.pageBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.collections.task2.pageBean.Book;

/**
 * JUnit test for book class.
 * 
 * @author simeon
 */
public class TestBook {

	private Book book;

	/**
	 * Set up method for test.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		List<String> myContent = new ArrayList<String>();
		myContent.add("1");
		myContent.add("2");
		myContent.add("3");
		myContent.add("4");
		myContent.add("5");
		myContent.add("6");
		myContent.add("7");
		book = new Book(myContent, 2);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#next()}.
	 */
	@Test
	public void testNext() {
		assertEquals("[1, 2]", book.next().toString());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#next()}.
	 */
	@Test
	public void testNextNullPage() {
		book.next();
		book.next();
		book.next();
		book.next();
		book.next();
		assertEquals(null, book.next());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#previous()}.
	 */
	@Test
	public void testPrevious() {
		book.next();
		book.next();
		assertEquals("[1, 2]", book.previous().toString());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#previous()}.
	 */
	@Test
	public void testPreviousNullPage() {
		assertEquals(null, book.previous());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		assertTrue(book.hasNext());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#hasNext()}.
	 */
	@Test
	public void testHasNextFalseTest() {
		book.next();
		book.next();
		book.next();
		book.next();
		book.next();
		book.next();
		assertFalse(book.hasNext());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#hasPrevious()}.
	 */
	@Test
	public void testHasPrevious() {
		book.next();
		book.next();
		assertTrue(book.hasPrevious());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#hasPrevious()}.
	 */
	@Test
	public void testHasPreviousFalseValue() {
		assertFalse(book.hasPrevious());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#firstPage()}.
	 */
	@Test
	public void testFirstPage() {
		assertEquals("[1, 2]", book.firstPage().toString());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#lastPage()}.
	 */
	@Test
	public void testLastPage() {
		assertEquals("[7]", book.lastPage().toString());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#getCurrentPageNumber()}.
	 */
	@Test
	public void testGetCurrentPageNumber() {
		book.next();
		assertEquals(1, book.getCurrentPageNumber());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#getPage(int)}
	 * .
	 */
	@Test
	public void testGetPage() {
		assertEquals("[5, 6]", book.getPage(2).toString());
	}

}
