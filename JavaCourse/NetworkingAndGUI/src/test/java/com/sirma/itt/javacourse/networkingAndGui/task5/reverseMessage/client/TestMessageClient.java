package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server.MessageServer;

/**
 * @author Simeon Iliev
 */
public class TestMessageClient {

	private static Logger log = Logger.getLogger(TestMessageClient.class);
	private MessageClient client;
	private MessageServer server;
	private MessageClientGUI clientUI;
	private JTextArea serverTextArea;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		serverTextArea = new JTextArea();
		server = new MessageServer(serverTextArea);
		clientUI = null;
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient#startClient()}
	 * .
	 */
	@Test
	public void testStartClient() {
		server.start();
		clientUI = new MessageClientGUI();
		client = new MessageClient(clientUI);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(clientUI.getMessageArea().getText().contains("Welcome"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient#stopClient()}
	 * .
	 */
	@Test
	public void testStopClient() {
		server.start();
		clientUI = new MessageClientGUI();
		client = new MessageClient(clientUI);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		server.stopServer();
		assertTrue(clientUI.getMessageArea().getText().contains("Client is stopping"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient#sendMessageToServer(java.lang.String)}
	 * .
	 */
	@Test
	public void testSendMessageToServer() {
		server.start();
		clientUI = new MessageClientGUI();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		
		clientUI.sendMessage("This is a test");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(clientUI.getMessageArea().getText().contains("This is a test"));
		server.stopServer();
	}

}
