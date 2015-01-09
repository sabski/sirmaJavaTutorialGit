/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.managers;

import static org.junit.Assert.*;

import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;

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
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		thread = Mockito.mock(ClientThread.class);
		window = Mockito.mock(MainClientWindow.class);
		Mockito.when(window.getUsers()).thenReturn(
				new DefaultListModel<String>(), new DefaultListModel<String>(),
				new DefaultListModel<String>());
		Mockito.when(window.getUserList()).thenReturn(new JList<String>(),
				new JList<String>(), new JList<String>());
		// .thenReturn(new JList<String>());
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor#interpretMessage(com.sirma.itt.javacourse.chat.common.Message, com.sirma.itt.javacourse.chat.common.ChatUser)}
	 * .
	 */
	@Test
	public void testInterpretMessage() {
		Message message;
		// Test simple message
		message = new Message("test", 0, TYPE.MESSAGE, "test");
		interpreter.interpretMessage(message, null);
		Mockito.verify(interpreter).displayMessage(message);

		// Test Start chat
		message = new Message("test", 0, TYPE.STARTCHAT, "test");
		interpreter.interpretMessage(message, null);
		Mockito.verify(interpreter).createNewChatWindow(message);

		// Test Client Approved
		// message = new Message("test", 0, TYPE.APPROVED, "test");
		// interpreter.interpretMessage(message, null);
		// Mockito.verify(interpreter).clientApprover(message);

		// Test Refused Message
		// message = new Message("test", 0, TYPE.REFUSED, "test");
		// interpreter.interpretMessage(message, null);
		// Mockito.verify(interpreter).serverRefused(message);

		// Test Userlist message
		message = new Message("[test]", 0, TYPE.USERLIST, "test");
		interpreter.interpretMessage(message, new ChatUser("", new Socket()));
		Mockito.verify(controler).updateUserList("[test]");

		// Test Userlist add message
		message = new Message("[test]", 0, TYPE.USERLISTADD, "test");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler).updateUserListAdd("[test]");
		;

		// Test Userlist remove message
		message = new Message("[test]", 0, TYPE.USERLISTREMOVE, "test");
		interpreter.interpretMessage(message, null);
		Mockito.verify(controler).updateUserListRemove("[test]");
		;

		// Test disconnect message
		message = new Message("[test]", 0, TYPE.DISCONNECT, "[test]");
		interpreter.interpretMessage(message, null);
		Mockito.verify(interpreter).createNewChatWindow(message);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor#displayMessage(Message)}
	 * .
	 */
	@Test
	public void testDisplayMessage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor#createNewChatWindow(Message)}
	 * .
	 */
	@Test
	public void testCreateNewChatWindow() {
		fail("Not yet implemented");
	}

}
