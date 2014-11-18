package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class RunServer {

	private static Logger log = Logger.getLogger(RunServer.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Be awesome...
		DateServer server = new DateServer();
		log.info(server.startServer());
		server.accepConnection();
	}

}
