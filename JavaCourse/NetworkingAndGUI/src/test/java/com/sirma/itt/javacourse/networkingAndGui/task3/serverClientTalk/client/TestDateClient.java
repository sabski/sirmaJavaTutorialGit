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
	private JTextArea textArea;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		textArea = new JTextArea();
		client = new DateClient(textArea);
		server = new DateServer();
		server.setTextArea(new JTextArea());

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#connect()}
	 * .
	 */
	@Test
	public void testConnect() {
		server.start();
		client.start();
		assertTrue(textArea.getText().contains("Connected to server"));
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
		client.start();
		assertTrue(textArea.getText().contains("Disconnected"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client.DateClient#getMessage()}
	 * .
	 */
	@Test
	public void testGetMessage() {
		server.start();
		client.start();
		assertTrue(textArea.getText().contains("Server time is "));
		server.stopServer();
	}

}
