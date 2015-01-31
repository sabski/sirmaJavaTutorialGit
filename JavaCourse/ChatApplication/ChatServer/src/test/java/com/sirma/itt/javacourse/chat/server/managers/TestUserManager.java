package com.sirma.itt.javacourse.chat.server.managers;

import static org.junit.Assert.*;

import java.net.Socket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.server.controler.ServerController;
import com.sirma.itt.javacourse.chat.server.manager.ServerMessageInterpreter;
import com.sirma.itt.javacourse.chat.server.manager.UserManager;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * Test class for {@link UserManager}
 * 
 * @author Simon Iliev
 * 
 */
public class TestUserManager {

	@Spy
	private UserManager manager;

	@Mock
	private ServerController controler;

	@Mock
	private ChatUser user;

	@Mock
	private Socket socket;

	@Mock
	private ClientListenerThread clientThread;

	@Mock
	private ServerMessageInterpreter interpreter;

	@Before
	public void setUp() throws Exception {
		user = Mockito.mock(ChatUser.class);
		socket = Mockito.mock(Socket.class);
		clientThread = Mockito.mock(ClientListenerThread.class);
		controler = Mockito.mock(ServerController.class);
		interpreter = Mockito.mock(ServerMessageInterpreter.class);
		manager = Mockito.spy(new UserManager(controler));
	}

	/**
	 * Test validation of user names.
	 */
	@Test
	public void testValidateUserName() {
		assertTrue(manager.isValidName("user"));
		assertFalse(manager.isValidName("[user]"));
	}

	/**
	 * Test the registration of users.
	 */
	@Test
	public void testRegisterUser() {
		String username = "name";
		Mockito.when(clientThread.getUser()).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn(username, username);
		manager.getTempHolder().add(clientThread);
		manager.registerUser(user);
		assertTrue(manager.getUser(username) != null);
	}

	/**
	 * Test if user is rejected by sending him the proper message.
	 */
	@Test
	public void testRejectUser() {
		String username = "name";
		Message message = new Message("", 0, MessageType.REFUSED, username);
		Mockito.when(clientThread.getUser()).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn(username, username);
		Mockito.when(
				interpreter.generateMessage(MessageType.REFUSED, 0,
						"The user name you entered is invalid : " + username,
						MessageType.SERVER.toString())).thenReturn(message);
		manager.setInterpretator(interpreter);
		manager.getTempHolder().add(clientThread);
		manager.rejectUser(user);
		Mockito.verify(clientThread, Mockito.atLeastOnce())
				.sendMessage(message);
	}

	/**
	 * Test if user is added properly.
	 */
	@Test
	public void testAddUser() {
		String username = "name";
		Mockito.when(clientThread.getUser()).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn(username, username, "[asd");
		assertTrue(manager.addUser(clientThread));
		assertFalse(manager.addUser(clientThread));
	}
}
