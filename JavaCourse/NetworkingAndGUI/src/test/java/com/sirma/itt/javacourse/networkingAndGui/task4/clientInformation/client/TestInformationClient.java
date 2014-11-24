package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server.InformationServer;

/**
 * @author Simeon Iliev
 */
public class TestInformationClient {

	private static Logger log = Logger.getLogger(TestInformationClient.class);
	private InformationClient clientOne;
	private InformationClient clientTwo;
	private InformationServer server;
	private JTextArea serverArea;
	private JTextArea clientOneArea;
	private JTextArea clientTwoArea;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		serverArea = new JTextArea();
		clientOneArea = new JTextArea();
		clientTwoArea = new JTextArea();
		server = new InformationServer(serverArea);
		clientOne = new InformationClient(clientOneArea);
		clientTwo = new InformationClient(clientTwoArea);

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client.InformationClient#connect()}
	 * .
	 */
	@Test
	public void testConnect() {
		server.start();
		clientOne.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(clientOneArea.getText().contains("You are "));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client.InformationClient#readFromServer()}
	 * .
	 */
	@Test
	public void testReadFromServer() {
		server.start();
		clientOne.start();
		clientTwo.start();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(clientOneArea.getText().contains("Client number"));
		server.stopServer();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client.InformationClient#stopClient()}
	 * .
	 */
	@Test
	public void testStopClient() {
		server.start();
		clientOne.start();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		clientOne.stopClient();
		assertTrue(clientOneArea.getText().contains("Client is"));
		server.stopServer();
	}

}
