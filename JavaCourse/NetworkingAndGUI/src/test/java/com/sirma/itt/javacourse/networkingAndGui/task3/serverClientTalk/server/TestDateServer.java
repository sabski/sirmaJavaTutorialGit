package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient;

/**
 * Test class for {@link DateServer}.
 * 
 * @author Simeon Iliev
 */
public class TestDateServer {

	// private static Logger log = Logger.getLogger(TestDateServer.class);

	@Spy
	private DateServer server;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             sometshing went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		server = Mockito.spy(new DateServer(new JTextArea()));
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
		server.stopServer();
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
		server.start();

		client.connect();
		assertTrue(client.getMessage().contains("Server time is "));
		client.disconnect();
		server.stopServer();
		Mockito.verify(server, Mockito.atLeastOnce()).acceptConnection();

	}
}
