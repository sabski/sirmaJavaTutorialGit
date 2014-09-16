package comsirma.itt.javacourse.inputOutput.test.task5.directoryBrowser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
	private String path = "src/test/resources/";
	private String result = "home; simeon; Serializathion.txt; Destination.txt; Origin.txt; ";

	private String directoryPath = "src/test/resources/Origin.txt";
	private String resultForDirectory = directoryPath;

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
		assertEquals(result, browser.listContent(path));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser#listContent(java.lang.String)}
	 * .
	 */
	@Test
	public void testListContentWithFile() {
		assertEquals(resultForDirectory, browser.listContent(directoryPath));
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
