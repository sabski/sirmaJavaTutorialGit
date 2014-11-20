package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class InformationThread extends Thread {

	private static Logger log = Logger.getLogger(InformationThread.class);

	private final List<Socket> clientList;
	private final int newClientNumber;

	/**
	 * @param clientList
	 */
	public InformationThread(List<Socket> clientList, int newClientNumber) {
		this.clientList = clientList;
		this.newClientNumber = newClientNumber;
	}

	@Override
	public void run() {
		for (Socket clientSocket : clientList) {
			try (DataOutputStream outputStream = new DataOutputStream(
					clientSocket.getOutputStream())) {
				outputStream.writeUTF("Client number " + newClientNumber + " has connected.");
				outputStream.flush();
				clientSocket.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

}
