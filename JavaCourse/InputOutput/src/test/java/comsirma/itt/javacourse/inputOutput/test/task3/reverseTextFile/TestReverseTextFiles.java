package comsirma.itt.javacourse.inputOutput.test.task3.reverseTextFile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole;
import com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser;

/**
 * @author simeon
 */
public class TestReverseTextFiles {

	private WriteFileFromConsole fileWriter;
	private FileReverser reverser;
	private String originalContent = "1\n2\n3\n4\n5\n6\n7\n8\n9\n.";
	private String reverse = ".987654321";
	private String fileName = "src/test/resources/reverseSource.txt";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fileWriter = new WriteFileFromConsole();
		reverser = new FileReverser();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser#reverseFileContent(java.lang.String)}
	 * .
	 */
	@Test
	public void testReverseFile() {
		String content = fileName + "\n" + originalContent;
		Scanner scanner = new Scanner(content);
		IOUtils.setScanner(scanner);
		fileWriter.writeFile();
		try {
			reverser.reverseFileContent(fileName);
			assertEquals(reverse, IOUtils.readFile(fileName).replaceAll("\n", ""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser#reverseFileContent(java.lang.String)}
	 * .
	 * 
	 * @throws FileNotFoundException
	 */
	@Test(expected = FileNotFoundException.class)
	public void testReverseFileWrongFileName() throws FileNotFoundException {
			reverser.reverseFileContent("src");
	}
}
