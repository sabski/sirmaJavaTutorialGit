package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class RunClient {

	private static Logger log = Logger.getLogger(RunClient.class);

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		// TODO Have a nice day;

/*		ClientSoket client = new ClientSoket();
		log.info(client.connect());
		log.info(client.message());
		log.info(client.disconnect());*/
		new ClientGui();
	}

}
