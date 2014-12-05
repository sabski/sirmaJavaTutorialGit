package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server.InformationServer;

/**
 * Test class for {@link InformationClient}.
 * 
 * @author Simeon Iliev
 */
public class TestInformationClient {

	private static Logger log = Logger.getLogger(TestInformationClient.class);
	private InformationClient clientOne;
	private InformationClient clientTwo;
	private InformationServer server;
	private JTextArea serverArea;

	@Mock
	private InformationClientGUI clientOneUI;
	@Mock
	private InformationClientGUI clientTwoUI;

	private JTextArea messageOneArea;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		serverArea = new JTextArea();
		clientOneUI = Mockito.mock(InformationClientGUI.class);
		clientTwoUI = Mockito.mock(InformationClientGUI.class);
		server = new InformationServer(serverArea);
		messageOneArea = new JTextArea();
		Mockito.when(clientOneUI.getMessageWingow()).thenReturn(messageOneArea);
		Mockito.when(clientTwoUI.getMessageWingow()).thenReturn(messageOneArea);
		clientOne = new InformationClient(clientOneUI);
		clientTwo = new InformationClient(clientTwoUI);
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
		assertTrue(messageOneArea.getText().contains("You are "));
		clientOne.stopClient();
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
		assertTrue(messageOneArea.getText().contains("Client number"));
		clientOne.stopClient();
		clientTwo.stopClient();
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
		assertTrue(messageOneArea.getText().contains("Client is"));
		server.stopServer();
	}

}
