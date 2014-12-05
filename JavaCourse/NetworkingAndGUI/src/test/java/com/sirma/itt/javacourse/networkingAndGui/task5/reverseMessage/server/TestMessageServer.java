/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClient;
import com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client.MessageClientGUI;

/**
 * @author siliev
 * 
 */
public class TestMessageServer {

	private static Logger log = Logger.getLogger(TestMessageServer.class);

	private MessageClient client;
	@Mock
	private MessageClientGUI clientUI;
	private MessageServer server;
	private JTextArea serverTextArea;
	private JTextArea clientTextArea;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		clientUI = Mockito.mock(MessageClientGUI.class);
		clientTextArea = new JTextArea();
		Mockito.when(clientUI.getMessageArea()).thenReturn(clientTextArea);
		client = new MessageClient(clientUI);
		serverTextArea = new JTextArea();
		server = new MessageServer(serverTextArea);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server.MessageServer#readClientMessage()}
	 * .
	 */
	@Test
	public void testReadClientMessage() {
		server.start();
		client.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		client.sendMessageToServer("aaaa");
		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		client.stopClient();
		server.stopServer();
		assertTrue(clientTextArea.getText().contains("aaaa"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server.MessageServer#startServer()}
	 * .
	 */
	@Test
	public void testStartServer() {
		server.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		server.stopServer();
		assertTrue(serverTextArea.getText().contains("Server is starting"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server.MessageServer#stopServer()}
	 * .
	 */
	@Test
	public void testStopServer() {
		server.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		server.stopServer();
		assertTrue(serverTextArea.getText().contains("Server is stopped"));
	}

}
