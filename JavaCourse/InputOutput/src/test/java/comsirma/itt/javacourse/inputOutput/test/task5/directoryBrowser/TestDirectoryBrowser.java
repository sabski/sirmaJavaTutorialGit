package comsirma.itt.javacourse.inputOutput.test.task5.directoryBrowser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser;

/**
 * Test for DirectoryBrowser class.
 * 
 * @author simeon
 */
public class TestDirectoryBrowser {

	private DirectoryBrowser browser;
	private String path = "src/test/resources/";
	private String result = "home\nsimeon\nSerializathion.txt\nDestination.txt\ntest2.txt\nOrigin.txt\nreverseSource.txt\n";

	private String directoryPath = "src/test/resources/Origin.txt";
	private String resultForDirectory = "The path you entered leeds to a file " + directoryPath
			+ "\n";

	private String nullPath = null;

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	/**
	 * @throws java.lang.Exception
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
		browser.listContent(path);
		assertEquals(result, log.getLog());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser.DirectoryBrowser#listContent(java.lang.String)}
	 * .
	 */
	@Test
	public void testListContentWithDirectory() {
		browser.listContent(directoryPath);
		assertEquals(resultForDirectory, log.getLog());
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
