package com.sirma.itt.javacourse.inputoutput.task4.transferingObjects;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for transferring objects.
 * 
 * @author simeon
 */
public class TransferObject {

	private InputStream input;
	private OutputStream output;

	/**
	 * Constructor for the TransferObject which contains the input and output streams of files.
	 * 
	 * @param input
	 *            the input stream to which data will be.
	 * @param output
	 *            the output stream from which the data will be read.
	 */
	public TransferObject(InputStream input, OutputStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	/**
	 * Getter method for input.
	 * 
	 * @return the input
	 */
	public InputStream getInput() {
		return input;
	}

	/**
	 * Setter method for input.
	 * 
	 * @param input
	 *            the input to set
	 */
	public void setInput(InputStream input) {
		this.input = input;
	}

	/**
	 * Getter method for output.
	 * 
	 * @return the output
	 */
	public OutputStream getOutput() {
		return output;
	}

	/**
	 * Setter method for output.
	 * 
	 * @param output
	 *            the output to set
	 */
	public void setOutput(OutputStream output) {
		this.output = output;
	}

	/**
	 * Start the transfer from the output stream to the input stream.
	 * 
	 * @param numberOfBytes
	 *            the number of bytes to be transfered between the streams.
	 * @param offset
	 *            the offset of the stream
	 * @return the number of transfered bytes.
	 */
	public int transfer(int numberOfBytes, int offset) {
		int result = -1;
		try {
			byte[] bytes = new byte[numberOfBytes];
			result = input.read(bytes, offset, numberOfBytes);
			output.write(bytes, 0, result-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
