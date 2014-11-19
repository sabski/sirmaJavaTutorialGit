package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * @author Simeon Iliev
 */
public class TestDateServer {

	private static Logger log = Logger.getLogger(TestDateServer.class);

	@Mock
	private DateServer server;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		server = Mockito.mock(DateServer.class);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer#startServer()}
	 * .
	 */
	@Test
	public void testStartServer() {
		Mockito.when(server.getLastMassage()).thenReturn("Server started");
		server.startServer();
		assertEquals("Server started", server.getLastMassage());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer#stopServer()}
	 * .
	 */
	@Test
	public void testStopServer() {
		Mockito.when(server.getLastMassage()).thenReturn("Server stopped");
		server.stopServer();
		assertEquals("Server stopped", server.getLastMassage());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer#accepConnection()}
	 * .
	 */
	@Test
	public void testAccepConnection() {
		Mockito.when(server.getLastMassage()).thenReturn("New client");

		assertEquals("New client", server.getLastMassage());
	}

}
