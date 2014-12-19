package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import com.sirma.itt.javacourse.networkingAndGui.ServerUI;

/**
 * @author Simeon Iliev
 */
public class RunMessageServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerUI(new MessageServer());
	}

}
