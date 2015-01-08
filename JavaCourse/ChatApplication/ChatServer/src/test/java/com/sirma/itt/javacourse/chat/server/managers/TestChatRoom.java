/**
 * 
 */
package com.sirma.itt.javacourse.chat.server.managers;

import static org.junit.Assert.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.server.manager.ChatRoom;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * Test class for {@link ChatRoom}
 * 
 * @author siliev
 * 
 */
public class TestChatRoom {

	private ChatRoom chatRoom;

	@Mock
	private ClientListenerThread thread;

	@Mock
	private Socket socket;

	@Mock
	private ObjectInputStream input;

	@Mock
	private ObjectOutputStream output;

	@Mock
	private ChatUser user;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {

		chatRoom = new ChatRoom();
		socket = Mockito.mock(Socket.class);
		input = Mockito.mock(ObjectInputStream.class);
		output = Mockito.mock(ObjectOutputStream.class);
		Mockito.when(socket.getInputStream()).thenReturn(input);
		Mockito.when(socket.getOutputStream()).thenReturn(output);
		user = Mockito.mock(ChatUser.class);
		thread = Mockito.mock(ClientListenerThread.class);
		Mockito.when(thread.getUser()).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn("Simeon")
				.thenReturn("Simeon");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoom#addUser(com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread)}
	 * .
	 */
	@Test
	public void testAddUser() {
		chatRoom.addUser(thread);
		assertTrue(chatRoom.containsUser("Simeon"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoom#containsUser(java.lang.String)}
	 * .
	 */
	@Test
	public void testContainsUserFalse() {
		assertFalse(chatRoom.containsUser("Simo"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoom#containsUser(java.lang.String)}
	 * .
	 */
	@Test
	public void testContainsUserTrue() {
		chatRoom.addUser(thread);
		assertTrue(chatRoom.containsUser("Simeon"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoom#removeUser(com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread)}
	 * .
	 */
	@Test
	public void testRemoveUser() {
		chatRoom.addUser(thread);
		chatRoom.removeUser(thread);
		assertFalse(chatRoom.containsUser("Simeon"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoom#isChatRoomEmpty()}
	 * .
	 */
	@Test
	public void testIsChatRoomEmptyTrue() {
		assertTrue(chatRoom.isChatRoomEmpty());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoom#isChatRoomEmpty()}
	 * .
	 */
	@Test
	public void testIsChatRoomEmptyFalse() {
		chatRoom.addUser(thread);
		chatRoom.addUser(thread);
		assertFalse(chatRoom.isChatRoomEmpty());
	}

}
