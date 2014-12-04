package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * Test class for {@link DateClient}
 * 
 * @author Simeon Iliev
 */
public class TestDateClient {

	private DateClient client;

	private DateServer server;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		client = new DateClient();
		server = new DateServer(new JTextArea());

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#connect()}
	 * .
	 */
	@Test
	public void testConnect() {
		server.start();
		assertTrue(client.connect().contains("Connected to server"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#disconnect()}
	 * .
	 */
	@Test
	public void testDisconnect() {
		server.start();
		client.connect();
		assertTrue(client.disconnect().contains("Disconnected"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#disconnect()}
	 * .
	 */
	@Test
	public void testDisconnectNoActiveConnection() {
		assertTrue(client.disconnect()
				.contains("There is no active connection"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#getMessage()}
	 * .
	 */
	@Test
	public void testGetMessage() {
		server.start();
		client.connect();
		assertTrue(client.getMessage().contains("Server time is "));
		client.disconnect();
		server.stopServer();
	}

}
