package comsirma.itt.javacourse.inputOutput.test.task2.fileWriter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole;

/**
 * Unit test for WriteFileFromConsole.
 * 
 * @author simeon
 */
public class TestConsoleWriter {

	private WriteFileFromConsole writer;
	private String fileData;
	private String fileName;
	private String line;

	/**
	 * Sets up variables
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		writer = new WriteFileFromConsole();
		fileName = "src/test/resources/test2.txt";
		fileData = "hello word\n sad \n sad\n.";
		line = fileData;
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole#writeFile()}
	 * .
	 */
	@Test
	public void testWriteFile() {
		Scanner scanner = new Scanner(line);
		IOUtils.setScanner(scanner);
		File file = new File(fileName);
		file.delete();
		writer.writeFile(fileName);
		try {
			assertEquals(fileData.replaceAll("\n", ""),
					IOUtils.readFile(fileName).replaceAll("\n", ""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole#writeFile()}
	 * .
	 */
	@Test(expected = NullPointerException.class)
	public void testWriteFileWithNullValues() {
		Scanner scanner = new Scanner(line);
		IOUtils.setScanner(scanner);
		String tmp = null;
		File file = new File(tmp);
		file.delete();
		writer.writeFile(fileName);
		try {
			assertEquals(fileData.replaceAll("\n", ""),
					IOUtils.readFile(fileName).replaceAll("\n", ""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
