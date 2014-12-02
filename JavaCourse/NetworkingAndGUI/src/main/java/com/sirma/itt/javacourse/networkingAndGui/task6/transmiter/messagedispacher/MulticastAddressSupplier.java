package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author siliev
 * 
 */
public class MulticastAddressSupplier {

	private static Logger log = Logger
			.getLogger(MulticastAddressSupplier.class);
	private List<InetAddress> addressBook;

	public MulticastSocket getFreeSocket() {
		for (InetAddress address : addressBook) {
			if (address.isMulticastAddress()) {
				try {
					MulticastSocket socket = new MulticastSocket(7015);
					socket.joinGroup(address);
					return socket;
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return null;
	}
	
	
	
}
