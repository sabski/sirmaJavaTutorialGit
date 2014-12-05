package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client.InformationClient;
import com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client.InformationClientGUI;

/**
 * Test class for {@link InformationServer}.
 * 
 * 
 * @author Simeon Iliev
 */
public class TestInformationServer {

	private static Logger log = Logger.getLogger(TestInformationServer.class);
	private InformationClient clientOne;
	private InformationServer server;
	private JTextArea serverArea;
	@Mock
	private InformationClientGUI clientOneArea;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		serverArea = new JTextArea();
		server = new InformationServer(serverArea);
		clientOneArea = Mockito.mock(InformationClientGUI.class);
		Mockito.when(clientOneArea.getMessageWingow()).thenReturn(
				new JTextArea());
		clientOne = new InformationClient(clientOneArea);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server.InformationServer#startServer()}
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
		assertTrue(serverArea.getText().contains("Server is starting"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server.InformationServer#stopServer()}
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
		assertTrue(serverArea.getText().contains("Server is stopped"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server.InformationServer#acceptConnetion()}
	 * .
	 */
	@Test
	public void testAcceptConnetion() {
		server.start();

		clientOne.start();
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		clientOne.stopClient();
		server.stopServer();
		assertTrue(serverArea.getText().contains("New client has connected"));
	}
}
