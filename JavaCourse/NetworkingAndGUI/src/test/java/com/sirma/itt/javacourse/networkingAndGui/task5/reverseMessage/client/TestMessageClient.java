package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server.MessageServer;

/**
 * Test class for {@link MessageClient}.
 * 
 * 
 * @author Simeon Iliev
 */
public class TestMessageClient {

	private static Logger log = Logger.getLogger(TestMessageClient.class);

	private MessageClient client;
	@Mock
	private MessageClientGUI clientUI;
	private MessageServer server;
	private JTextArea serverTextArea;
	private JTextArea clientTextArea;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		clientUI = Mockito.mock(MessageClientGUI.class);
		clientTextArea = new JTextArea();
		Mockito.when(clientUI.getMessageArea()).thenReturn(clientTextArea);
		client = new MessageClient(clientUI);
		serverTextArea = new JTextArea();
		server = new MessageServer();
		server.setTextArea(serverTextArea);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient#startClient()}
	 * .
	 */
	@Test
	public void testStartClient() {
		server.start();
		client.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		client.stopClient();
		server.stopServer();
		assertTrue(clientTextArea.getText().contains("Welcome"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient#stopClient()}
	 * .
	 */
	@Test
	public void testStopClient() {
		server.start();
		client.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		client.stopClient();
		server.stopServer();
		assertTrue(clientTextArea.getText().contains("Client will stop"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient#sendMessageToServer(java.lang.String)}
	 * .
	 */
	@Test
	public void testSendMessageToServer() {
		server.start();
		client.start();

		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		client.sendMessageToServer("This is a test");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		client.stopClient();
		server.stopServer();
		assertTrue(clientTextArea.getText().contains("This is a test"));
	}
}
