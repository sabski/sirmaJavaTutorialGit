package com.sirma.itt.javacourse.inputoutput.task4.transferingObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.rmi.CORBA.Util;

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
			OutputStream output = new FileOutputStream(Utils.readLine());
			TransferObject transfer = new TransferObject(input, output);
			Utils.printConsoleMessage("Input the number of bytes to transfer from the files");
			int numberOfBites = Utils.readInt();
			Utils.printConsoleMessage("Input offset for the stream.");
			int offset = Utils.readInt();
			Utils.printConsoleMessage("Number of transfered bytes = "
					+ transfer.transfer(numberOfBites, offset));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
