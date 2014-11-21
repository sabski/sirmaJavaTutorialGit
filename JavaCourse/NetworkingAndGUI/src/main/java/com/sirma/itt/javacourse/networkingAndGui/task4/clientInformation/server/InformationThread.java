package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

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

	}

}
