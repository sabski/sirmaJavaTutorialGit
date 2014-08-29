package comsirma.itt.javacourse.inputOutput.test.task2.fileWriter;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

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

	@Rule
	public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream
			.emptyStandardInputStream();

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
		line = fileName + "\n" + fileData;
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole#writeFile()}
	 * .
	 */
	@Test
	public void testWriteFile() {
/*		systemInMock.provideText(line);
		writer.writeFile();
		try {
			assertEquals(fileData.replaceAll("\n", ""),
					IOUtils.readFile(fileName).replaceAll("\n", ""));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
