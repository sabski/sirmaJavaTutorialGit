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
		server = Mockito.spy(new DateServer());
		server.setTextArea(new JTextArea());

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
		JTextArea textArea = new JTextArea();
		DateClient client = new DateClient(textArea);
		server.start();
		client.connect();
		client.getMessage();
		assertTrue(textArea.getText().contains("Server time is "));
		client.disconnect();
		server.stopServer();
		Mockito.verify(server, Mockito.atLeastOnce()).acceptConnections();

	}
}
