package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * @author Simeon Iliev
 */
public class TestDateClient {

	private DateClient client;

	private DateServer server;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		client = new DateClient();
		server = new DateServer();

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#connect()}
	 * .
	 */
	@Test
	public void testConnect() {
		server.startServer();
		assertTrue(client.connect().contains("Connected to server"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#connect()}
	 * .
	 */
	@Test
	public void testConnectFail() {
		assertTrue(client.connect().contains("Connection refused"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#disconnect()}
	 * .
	 */
	@Test
	public void testDisconnect() {
		server.startServer();
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
		assertTrue(client.disconnect().contains("There is no active connection"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#getMessage()}
	 * .
	 */
	@Test
	public void testGetMessage() {
		server.startServer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				server.acceptConnection();
			}
		}).start();
		client.connect();
		assertTrue(client.getMessage().contains("Server time is "));
		client.disconnect();
		server.stopServer();
	}

}
