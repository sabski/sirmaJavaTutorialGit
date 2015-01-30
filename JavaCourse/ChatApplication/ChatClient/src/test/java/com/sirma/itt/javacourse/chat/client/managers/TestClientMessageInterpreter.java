package com.sirma.itt.javacourse.chat.client.managers;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
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
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * @author siliev
 * 
 */
public class TestClientMessageInterpreter {

	private static final Logger LOGGER = Logger
			.getLogger(TestClientMessageInterpreter.class);

	@Spy
	private ClientMessageInterpretor interpreter;

	@Mock
	private ClientThread thread;

	@Spy
	private MainClientWindow window;

	@Mock
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
		// controler = Mockito.spy(UIControler.getInstance());
		// controler.registerChatPanel(new ChatsPanel());
		// controler.registerMainWindow(window);
		controler = Mockito.mock(UIControler.class);
		interpreter = Mockito.spy(new ClientMessageInterpretor(controler));
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

	/**
	 * Test method for InterpretMessage method with MESSAGE
	 */
	@Test
	public void testInterpretMessageMessage() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0, MessageType.MESSAGE,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce())
				.displayMessage(message);
	}

	/**
	 * Test method for InterpretMessage method with STARTCHAT
	 */
	@Test
	public void testInterpretMessageStartChat() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0, MessageType.STARTCHAT,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce()).createTab(message);
	}

	/**
	 * Test method for InterpretMessage method with APPROVED
	 */
	@Test
	public void testInterpretMessageApproved() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0, MessageType.APPROVED,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce()).welcomeClient(message);
	}

	/**
	 * Test method for InterpretMessage method with REFUSED
	 */
	@Test
	public void testInterpretMessageRefused() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0, MessageType.REFUSED,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce()).userNameRejected(
				message);
	}

	/**
	 * Test method for InterpretMessage method with USERLISTADD
	 */
	@Test
	public void testInterpretMessageUserListAdd() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0, MessageType.USERLISTADD,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce()).updateUserListAdd(
				message);
	}

	/**
	 * Test method for InterpretMessage method with USERLIST
	 */
	@Test
	public void testInterpretMessageUserList() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0, MessageType.USERLIST,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce()).updateUserList(
				message.getContent());
	}

	/**
	 * Test method for InterpretMessage method with USERLISTREMOVE
	 */
	@Test
	public void testInterpretMessageUserListRemove() {
		controler.registerChatPanel(new ChatsPanel());
		Message message = new Message("[ test ]", 0,
				MessageType.USERLISTREMOVE, "user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce()).updateUserListRemove(
				message.getContent());
	}

	/**
	 * Test method for InterpretMessage method with DISCONNECT
	 */
	@Test
	public void testInterpretMessageDisconnect() {
		controler.registerChatPanel(new ChatsPanel());
		try {
			LanguageController.loadCurrentLanguage();
		} catch (MalformedURLException e) {
			LOGGER.info(e.getMessage(), e);
		}
		Message message = new Message("[ test ]", 0, MessageType.DISCONNECT,
				"user");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler, Mockito.atLeastOnce())
				.displayMessage(message);
	}
}
