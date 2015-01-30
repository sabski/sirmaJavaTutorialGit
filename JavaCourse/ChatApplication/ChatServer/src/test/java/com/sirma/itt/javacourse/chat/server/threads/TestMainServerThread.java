package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.chat.server.controler.ServerController;

/**
 * Test class for {@link MainServerThread} class.
 * 
 * @author siliev
 * 
 */
public class TestMainServerThread {

	private static final Logger LOGGER = Logger
			.getLogger(TestMainServerThread.class);
	private int port = 7000;
	private String address = "localhost";
	private ServerController controler;
	private MainServerThread mainThread;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		controler = new ServerController();
		mainThread = new MainServerThread(controler, 7000);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.threads.MainServerThread#startServer()}
	 * .
	 */
	@Test
	public void testStartServer() {

		mainThread.start();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
		//assertTrue(textArea.getText().contains("started"));
		mainThread.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.threads.MainServerThread#acceptConnections()}
	 * .
	 */
	@Test
	public void testAcceptConnections() {
		Socket socket = null;
		mainThread.start();
		try {
			Thread.sleep(400);
			socket = new Socket(address, port);
			Thread.sleep(400);
			socket.close();
		} catch (InterruptedException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		mainThread.stopServer();
	//	assertTrue(textArea.getText().contains("Client has connected"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.threads.MainServerThread#stopServer()}
	 * .
	 */
	@Test
	public void testStopServer() {
		mainThread.start();
		try {
			Thread.sleep(400);
			mainThread.stopServer();
			Thread.sleep(200);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	//	assertTrue(textArea.getText().contains("Stoping server"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.threads.MainServerThread#displayMessage(java.lang.String)}
	 * .
	 */
	@Test
	public void testDisplayMessage() {
		String message = "TestMessage";
		mainThread.displayMessage(message);
	//	assertTrue(textArea.getText().contains(message));
	}

}
