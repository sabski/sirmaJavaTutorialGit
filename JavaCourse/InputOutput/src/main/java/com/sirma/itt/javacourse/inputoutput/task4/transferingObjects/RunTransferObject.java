package com.sirma.itt.javacourse.inputoutput.task4.transferingObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for running the Transfer object class.
 * 
 * @author simeon
 */
public class RunTransferObject {

	/**
	 * The main method for the application.
	 * 
	 * @param args
	 *            the argument for the main method.
	 */
	public static void main(String[] args) {

		try {
			Utils.printConsoleMessage("Input file from which to read data.");
			InputStream input = new FileInputStream(Utils.readLine());
			Utils.printConsoleMessage("Input file name to write data.");
			OutputStream output = new FileOutputStream("test2.txt");
			TransferObject transfer = new TransferObject(input, output);
			Utils.printConsoleMessage("Number of transfered bytes = " + transfer.transfer(15, 0));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
