package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import static org.junit.Assert.*;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client.MulticastClient;
import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client.MulticastClientUI;

/**
 * Test class for {@link MulticastServer}.
 * 
 * @author siliev
 * 
 */
public class TestMulticastServer {

	private static Logger log = Logger.getLogger(TestMulticastServer.class);

	private MulticastClient client;

	private MulticastServer server;

	@Mock
	private MulticastClientUI clientUI;
	private JTextArea clientTextArea;

	private JTextArea serverMessageArea;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		clientTextArea = new JTextArea();
		clientUI = Mockito.mock(MulticastClientUI.class);
		Mockito.when(clientUI.getMessageWingow()).thenReturn(clientTextArea);
		client = new MulticastClient(clientUI);
		serverMessageArea = new JTextArea();
		server = new MulticastServer(serverMessageArea);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server.MulticastServer#startServer()}
	 * .
	 */
	@Test
	public void testStartServer() {
		server.start();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		server.stopServer();
		assertTrue(serverMessageArea.getText().contains("Server started"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server.MulticastServer#stopServer()}
	 * .
	 */
	@Test
	public void testStopServer() {
		server.start();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		server.stopServer();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(serverMessageArea.getText().contains("Server is stoping"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server.MulticastServer#acceptConnections()}
	 * .
	 */
	@Test
	public void testAcceptConnections() {
		server.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		client.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		client.interrupt();
		server.stopServer();
		assertTrue(serverMessageArea.getText().contains("Address"));
	}

}
