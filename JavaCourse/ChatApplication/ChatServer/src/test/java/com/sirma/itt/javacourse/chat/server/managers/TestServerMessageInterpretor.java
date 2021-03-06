package com.sirma.itt.javacourse.chat.server.managers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.server.manager.ChatRoomManager;
import com.sirma.itt.javacourse.chat.server.manager.ServerMessageInterpreter;
import com.sirma.itt.javacourse.chat.server.manager.UserManager;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * Test class for {@link ServerMessageInterpreter}.
 * 
 * @author siliev
 * 
 */
public class TestServerMessageInterpretor {

	@Mock
	private UserManager manager = Mockito.mock(UserManager.class);

	@Spy
	private ChatRoomManager chatRoom = Mockito.spy(new ChatRoomManager());
	@Spy
	private ServerMessageInterpreter interpreter;

	@Mock
	private ClientListenerThread thread;

	@Mock
	private ChatUser user;

	@Mock
	private ClientListenerThread listener;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		interpreter = Mockito.spy(new ServerMessageInterpreter(manager,
				chatRoom));
		user = Mockito.mock(ChatUser.class);
		thread = Mockito.mock(ClientListenerThread.class);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ServerMessageInterpreter#interpretMessage(com.sirma.itt.javacourse.chat.common.Message, com.sirma.itt.javacourse.chat.common.ChatUser)}
	 * .
	 */
	@Test
	public void testInterpretMessage() {
		Message message = new Message("Joke", 0, MessageType.MESSAGE, "MEME");
		interpreter.interpretMessage(message, user);
		Mockito.verify(chatRoom).getRoomById(0L);
	}
	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.server.manager.ServerMessageInterpreter#generateMessage(com.sirma.itt.javacourse.chat.common.Message.TYPE, long, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testGenerateMessage() {
		assertTrue(interpreter.generateMessage(MessageType.MESSAGE, 0, "", "") instanceof Message);
	}

}
