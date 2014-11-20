package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient;

/**
 * @author Simeon Iliev
 */
public class TestDateServer {

	private static Logger log = Logger.getLogger(TestDateServer.class);

	@Spy
	private DateServer server;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		server = Mockito.spy(new DateServer());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.server.DateServer#startServer()}
	 * .
	 */
	@Test
	public void testStartServer() {
		server.startServer();
		Mockito.verify(server, Mockito.atLeastOnce()).startServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.server.DateServer#stopServer()}
	 * .
	 */
	@Test
	public void testStopServer() {
		server.startServer();
		server.stopServer();
		Mockito.verify(server, Mockito.atLeastOnce()).stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.server.DateServer#acceptConnection()}
	 * .
	 */
	@Test
	public void testAccepConnection() {
		DateClient client = Mockito.spy(new DateClient());
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
		Mockito.verify(server, Mockito.atLeastOnce()).acceptConnection();

	}
}
