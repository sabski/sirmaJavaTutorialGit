package com.sirma.itt.javacourse.chat.client.managers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.chat.client.controller.UIControler;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;

/**
 * @author siliev
 * 
 */
public class TestClientMessageInterpreter {

	@Spy
	private ClientMessageInterpretor interpreter;

	@Mock
	private ClientThread thread;

	@Mock
	private MainClientWindow window;

	@Spy
	private UIControler controler;

	/**
	 * Set up before test method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		thread = Mockito.mock(ClientThread.class);
		window = Mockito.mock(MainClientWindow.class);
		controler = Mockito.spy(UIControler.getInstance());
		controler.registerChatPanel(new ChatsPanel());
		controler.registerMainWindow(window);
		interpreter = Mockito.spy(new ClientMessageInterpretor(thread));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor#generateMessage(com.sirma.itt.javacourse.chat.common.Message.TYPE, long, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testGenerateMessage() {
		assertTrue(interpreter.generateMessage(MessageType.MESSAGE, 0, "", "") instanceof Message);
	}

}
