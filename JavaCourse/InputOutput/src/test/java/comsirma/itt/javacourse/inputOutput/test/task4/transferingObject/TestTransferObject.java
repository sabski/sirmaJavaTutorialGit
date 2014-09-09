package comsirma.itt.javacourse.inputOutput.test.task4.transferingObject;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.inputoutput.task4.transferingObjects.TransferObject;

/**
 * Class for testing the transferring data between files.
 * 
 * @author simeon
 */
public class TestTransferObject {

	private TransferObject transporter;
	private TransferObject transporter2;

	private InputStream input;
	private OutputStream output;

	private String fileSource = "src/test/resources/Origin.txt";
	private String fileDestinathion = "src/test/resources/Destination.txt";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		input = new FileInputStream(fileSource);
		output = new FileOutputStream(fileDestinathion);
		transporter = new TransferObject(input, output);
		transporter2 = new TransferObject(input, null);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task4.transferingObjects.TransferObject#transfer(int, int)}
	 * .
	 */
	@Test
	public void testTransfer() {
		assertEquals(15, transporter.transfer(15, 0));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task4.transferingObjects.TransferObject#transfer(int, int)}
	 * . Test when we use an overflowing offset.
	 */
	@Test
	public void testTransferOutOfrange() {
		assertEquals(-1, transporter.transfer(15, 10000));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task4.transferingObjects.TransferObject#transfer(int, int)}
	 * .
	 */
	@Test
	public void testTransferToMuchBytes() {
		assertEquals(30, transporter.transfer(150000, 0));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task4.transferingObjects.TransferObject#transfer(int, int)}
	 * .
	 */
	@Test(expected = NullPointerException.class)
	public void testTransferNullBuffer() {
		transporter2.transfer(15, 0);
	}

}
