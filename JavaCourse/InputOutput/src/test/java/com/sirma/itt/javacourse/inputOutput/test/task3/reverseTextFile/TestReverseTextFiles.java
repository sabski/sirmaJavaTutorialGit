package com.sirma.itt.javacourse.inputOutput.test.task3.reverseTextFile;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole;
import com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser;

/**
 * JUnit test class for ReverseTextFiles.class
 * 
 * @author simeon
 */
public class TestReverseTextFiles {

	private Logger log = Logger.getLogger(TestReverseTextFiles.class.getName());
	private WriteFileFromConsole fileWriter;
	private FileReverser reverser;
	private String originalContent = "1\n2\n3\n4\n5\n6\n7\n8\n9\n.";
	private String reverse = ".987654321";
	private String fileName = "/reverseSource.txt";

	/**
	 * Set up method for the test.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		fileWriter = new WriteFileFromConsole();
		reverser = new FileReverser();
		if (new File(getClass().getResource("").getPath() + fileName).exists()) {
			new File(fileName).delete();
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser#reverseFileContent(java.lang.String)}
	 * .
	 */
	@Test
	public void testReverseFile() {
		String content = originalContent;
		Scanner scanner = new Scanner(content);
		IOUtils.setScanner(scanner);
		fileWriter.writeFile(fileName);
		try {
			reverser.reverseFileContent(getClass().getResource("").getPath() + fileName);
			assertEquals(reverse, IOUtils.readFile(getClass().getResource("").getPath() + fileName)
					.replaceAll("\n", ""));
		} catch (FileNotFoundException e) {
			log.error("File not found", e);
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser#reverseFileContent(java.lang.String)}
	 * .
	 * 
	 * @throws FileNotFoundException
	 *             the file was not found
	 */
	@Test(expected = FileNotFoundException.class)
	public void testReverseFileWrongFileName() throws FileNotFoundException {
		reverser.reverseFileContent("src");
	}
}
