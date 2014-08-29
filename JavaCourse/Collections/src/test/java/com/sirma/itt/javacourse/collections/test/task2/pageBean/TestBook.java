package com.sirma.itt.javacourse.collections.test.task2.pageBean;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sirma.itt.javacourse.collections.task2.pageBean.Book;

/**
 * @author simeon
 */
public class TestBook {

	private Book book;

	/**
	 * @throws java.lang.Exception
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
		// List<?> firstPage = book.next();
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#previous()}.
	 */
	@Test
	public void testPrevious() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#hasPrevious()}.
	 */
	@Test
	public void testHasPrevious() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#firstPage()}.
	 */
	@Test
	public void testFirstPage() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#lastPage()}.
	 */
	@Test
	public void testLastPage() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#getCurrentPageNumber()}.
	 */
	@Test
	public void testGetCurrentPageNumber() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.collections.task2.pageBean.Book#getPage(int)}
	 * .
	 */
	@Test
	public void testGetPage() {
		// fail("Not yet implemented");
	}

}
