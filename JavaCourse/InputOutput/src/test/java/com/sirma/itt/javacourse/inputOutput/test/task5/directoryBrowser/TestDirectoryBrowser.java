package com.sirma.itt.javacourse.inputOutput.test.task5.directoryBrowser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser;

/**
 * Test for DirectoryBrowser class.
 * 
 * @author simeon
 */
public class TestDirectoryBrowser {

	private DirectoryBrowser browser;
	private String result = "com; Serializathion.txt; Destination.txt; Origin.txt; ";
	private String nullPath = null;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		browser = new DirectoryBrowser();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser#listContent(java.lang.String)}
	 * .
	 */
	@Test
	public void testListContent() {
		assertEquals(result, browser.listContent(getClass().getResource("/").getPath()));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser#listContent(java.lang.String)}
	 * .
	 */
	@Test
	public void testListContentWithFile() {
		assertTrue(browser.listContent(getClass().getResource("/Origin.txt").getPath()).endsWith(
				"sirmaJavaTutorialGit/JavaCourse/InputOutput/target/test-classes/Origin.txt"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser#listContent(java.lang.String)}
	 * .
	 */
	@Test(expected = NullPointerException.class)
	public void testListContentWithNullPath() {
		browser.listContent(nullPath);
	}

}
