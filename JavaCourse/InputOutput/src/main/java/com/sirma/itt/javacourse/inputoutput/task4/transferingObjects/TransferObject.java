package com.sirma.itt.javacourse.inputoutput.task4.transferingObjects;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

/**
 * Class for transferring objects. By using the provided in the constructor input and output
 * streams.
 * 
 * @author simeon
 */
public class TransferObject {

	private final Logger log = Logger.getLogger(TransferObject.class.getName());
	private InputStream input;
	private OutputStream output;

	/**
	 * Constructor for the TransferObject which contains the input and output
	 * streams of files.
	 * 
	 * @param input
	 *            the input stream to which data will be read.
	 * @param output
	 *            the output stream from which the data will be written to.
	 */
	public TransferObject(InputStream input, OutputStream output) {
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
	 * Start the transfer from the output stream to the input stream. Reads up to numberOfBytes
	 * bytes of data from the input stream into an array of bytes. An attempt is made to read as
	 * many as numberOfBytes bytes, but a smaller number may be read. The number of bytes actually
	 * read is returned as an integer. This method blocks until input data is available, end of file
	 * is detected, or an exception is thrown. If numberOfBytes is zero, then no bytes are read and
	 * 0 is returned. Otherwise, there is an attempt to read at least one byte. If no byte is
	 * available because the stream is at end of file, the value -1 is returned. Otherwise, at least
	 * one byte is read and stored into the OutputStream.
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
			output.write(bytes, 0, result);
		} catch (IOException | IndexOutOfBoundsException e) {
			log.error(e.getMessage(), e);
		}

		return result;
	}

}
