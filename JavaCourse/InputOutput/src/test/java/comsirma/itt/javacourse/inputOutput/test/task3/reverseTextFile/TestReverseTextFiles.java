package comsirma.itt.javacourse.inputOutput.test.task3.reverseTextFile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.sirma.itt.javacourse.Utils;
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

	@Rule
	public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream
			.emptyStandardInputStream();

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
	 * {@link com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile.FileReverser#reverseFile(java.lang.String)}
	 * .
	 */
	@Test
	public void testReverseFile() {
		systemInMock.provideText(fileName + "\n" + originalContent);
		fileWriter.writeFile();
		reverser.reverseFile(fileName);
		try {
			assertEquals(reverse, Utils.readFile(fileName).replaceAll("\n", ""));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
