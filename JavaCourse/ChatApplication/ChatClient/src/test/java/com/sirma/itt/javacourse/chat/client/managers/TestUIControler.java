package com.sirma.itt.javacourse.chat.client.managers;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.sirma.itt.javacourse.chat.client.controller.UIControler;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.client.ui.componnents.PopUpMessages;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * Test class for {@link UIControler}.
 * 
 * @author Simon Iliev
 * 
 */
public class TestUIControler {

	@Spy
	private UIControler controler;

	@Mock
	private MainClientWindow window;

	@Mock
	private ChatsPanel panel;

	@Spy
	private DefaultListModel<String> value;

	@Mock
	private ClientInfo info;

	@Mock
	private ClientThread thread;

	@Mock
	private PopUpMessages popUp;

	@Mock
	private ClientMessageInterpretor interpretor;

	@Before
	public void setUp() throws Exception {
		window = Mockito.mock(MainClientWindow.class);
		panel = Mockito.mock(ChatsPanel.class);
		info = Mockito.mock(ClientInfo.class);
		thread = Mockito.mock(ClientThread.class);
		controler = Mockito.spy(new UIControler());
		controler.registerMainWindow(window);
		controler.registerChatPanel(panel);
		controler.setClientInfo(info);
		popUp = Mockito.mock(PopUpMessages.class);
		controler.setPopUps(popUp);
		controler.setThread(thread);
	}

	@Test
	public void testUpdateUserList() {
		DefaultListModel<String> value = new DefaultListModel<String>();
		value.addElement("test");
		JList<String> list = new JList<String>();
		Mockito.when(window.getUsers()).thenReturn(value);
		Mockito.when(window.getUserList()).thenReturn(list);
		controler.updateUserList("hmm");
		Mockito.verify(window, Mockito.atLeastOnce()).getUsers();
	}

	@Test
	public void testUpdateUserListAdd() {
		value = Mockito.spy(new DefaultListModel<String>());
		value.addElement("test");
		JList<String> list = new JList<String>();
		Mockito.when(window.getUsers()).thenReturn(value).thenReturn(value);
		Mockito.when(window.getUserList()).thenReturn(list);
		Message message = new Message("Hello", 0, MessageType.USERLISTREMOVE,
				"user");
		controler.updateUserListAdd(message);
		assertTrue(value.contains("Hello"));
	}

	@Test
	public void testUpdateUserListRemove() {
		DefaultListModel<String> value = new DefaultListModel<String>();
		value.addElement("Hello");
		JList<String> list = new JList<String>();
		Mockito.when(window.getUsers()).thenReturn(value);
		Mockito.when(window.getUserList()).thenReturn(list);
		Message message = new Message("Hello", 0, MessageType.USERLISTREMOVE,
				"");
		controler.updateUserListRemove(message.getContent());
		assertFalse(value.contains("Hello"));
	}

	@Test
	public void testServerDisconnect() {
		controler.serverDisconnect();
		Mockito.verify(window, Mockito.atLeastOnce()).toogleText();
		Mockito.verify(panel, Mockito.atLeastOnce()).resetChats();
	}

	@Test
	public void testWelcomeCleint() {

		Message messages = new Message("Simeon", 0, MessageType.APPROVED,
				"Server");
		try {
			LanguageController.loadCurrentLanguage();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		controler.welcomeClient(messages);
		Mockito.verify(window, Mockito.atLeastOnce()).setTitle(
				LanguageController.getWord("titleclient") + " "
						+ messages.getContent());
	}

	public void testCreateChatRoom() {

		List<String> list = new ArrayList<String>();
		list.add("test");
		Mockito.when(info.getUserName()).thenReturn("simeon", "simeon");

		controler.createChatRoom(list);
		Mockito.when(panel.checkPanels(list)).thenReturn(true);
		Mockito.verify(thread, Mockito.atLeastOnce())
				.sendMessage(
						new Message(list.toString(), 0, MessageType.STARTCHAT,
								"simeon"));
	}

	@Test
	public void testInputUserName() {
		String result = "simeon";
		Mockito.when(popUp.inputUserName()).thenReturn(result);
		assertEquals(result, controler.inputUserName());
		Mockito.verify(panel, Mockito.atLeastOnce()).resetChats();
	}

	@Test
	public void testUserNameRejected() {
		interpretor = Mockito.mock(ClientMessageInterpretor.class);
		String result = "simeon";
		Message resultingMessage = new Message("", 0, MessageType.CONNECT, "");
		Mockito.when(popUp.inputUserName()).thenReturn(result);
		Mockito.when(thread.getManager()).thenReturn(interpretor);
		Mockito.when(
				interpretor.generateMessage(MessageType.CONNECT, 0, result,
						null)).thenReturn(resultingMessage);
		assertEquals(result, controler.inputUserName());
		Message message = new Message("", 0, MessageType.REFUSED, "SERVER");
		controler.userNameRejected(message);

		Mockito.verify(thread, Mockito.atLeastOnce()).sendMessage(
				resultingMessage);
	}

	@Test
	public void tesSendMessahe() {
		interpretor = Mockito.mock(ClientMessageInterpretor.class);
		String result = "simeon";
		Message resultingMessage = new Message(result, 0, MessageType.CONNECT,
				result);
		Mockito.when(info.getUserName()).thenReturn(result);
		Mockito.when(panel.getSelectedChat()).thenReturn(0L);
		Mockito.when(thread.getManager()).thenReturn(interpretor);
		Mockito.when(
				interpretor.generateMessage(MessageType.MESSAGE, 0, result,
						result)).thenReturn(resultingMessage);
		controler.sendMessage(result);
		Mockito.verify(thread, Mockito.atLeastOnce()).sendMessage(
				resultingMessage);

	}
}
