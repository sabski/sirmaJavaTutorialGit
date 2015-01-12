package com.sirma.itt.javacourse.chat.server.managers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.chat.server.manager.ChatRoom;
import com.sirma.itt.javacourse.chat.server.manager.ChatRoomManager;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * Test class for {@link ChatRoomManager}.
 * 
 * @author siliev
 * 
 */
public class TestChatRoomManager {

	private ChatRoomManager manager = new ChatRoomManager();

	@Mock
	private ClientListenerThread user;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoomManager#createChatRoom()}
	 * .
	 */
	@Test
	public void testCreateChatRoom() {
		Long id = manager.createChatRoom();
		assertTrue(manager.getRoomById(id) instanceof ChatRoom);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoomManager#getRoomById(java.lang.Long)}
	 * .
	 */
	@Test
	public void testGetRoomById() {
		Long id = manager.createChatRoom();
		assertTrue(manager.getRoomById(id) instanceof ChatRoom);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ChatRoomManager#removeUserFromChats(com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread)}
	 * .
	 */
	@Test
	public void testRemoveUserFromChats() {
		user = Mockito.mock(ClientListenerThread.class);
		Mockito.when(user.getUser().getUsername()).thenReturn("test");
		manager.getCommonRoom().addUser(user);
		manager.removeUserFromChats(user);
		assertTrue(manager.getCommonRoom().containsUser("test"));
	}

}
