/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client;

import static org.junit.Assert.*;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server.MulticastServer;
import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server.MulticastServerUI;

/**
 * Test class for {@link MulticastClient}.
 * 
 * @author siliev
 * 
 */
public class TestMulticastClient {

	private static Logger log = Logger.getLogger(TestMulticastClient.class);

	private MulticastClient client;

	private MulticastServer server;

	@Mock
	private MulticastClientUI clientUI;
	private JTextArea clientTextArea;

	private JTextArea serverMessageArea;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		clientTextArea = new JTextArea();
		clientUI = Mockito.mock(MulticastClientUI.class);
		Mockito.when(clientUI.getMessageWingow()).thenReturn(clientTextArea);
		client = new MulticastClient(clientUI);
		serverMessageArea = new JTextArea();
		server = new MulticastServer(serverMessageArea);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client.MulticastClient#readPackegeData()}
	 * .
	 */
	@Test
	public void testReadPackegeData() {
		server.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		client.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		client.stopClient();
		server.stopServer();
		assertTrue(clientTextArea.getText().contains("listeing"));
	}

}
