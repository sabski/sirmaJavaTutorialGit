/**
 * 
 */
package com.sirma.itt.javacourse.chat.server.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;

/**
 * @author siliev
 * 
 */
public class ChannelThread extends Thread {

	private static Logger log = Logger.getLogger(ChannelThread.class);
	private List<ChatUser> userList;

	/**
	 * @param userList
	 */
	public ChannelThread(ChatUser... userList) {
		this.userList = new ArrayList<>();
		this.userList.addAll(Arrays.asList(userList));
	}

	@Override
	public void run() {
		log.info("Started new Channel Thred");
	}

	public void addUser(ChatUser user) {
		userList.add(user);
	}
	
	private void stopChannel(){
		
	}

	@Override
	public void interrupt() {
		stopChannel();
		super.interrupt();
	}
}
