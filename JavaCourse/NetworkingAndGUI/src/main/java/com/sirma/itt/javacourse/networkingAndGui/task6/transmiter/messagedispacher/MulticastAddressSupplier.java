package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.MathUtil;

/**
 * Class that supplies multicast addresses. These addresses are to be given to
 * clients that want to listen to multicast messages. Addresses can be added to
 * the supplier.
 * 
 * @author siliev
 * 
 */
public class MulticastAddressSupplier {

	private static final Logger LOGGER = Logger
			.getLogger(MulticastAddressSupplier.class);
	private List<InetAddress> addressBook;

	/**
	 * Select a random multicast {@link InetAddress} address from the list.
	 * 
	 * @return the randomly selected address.
	 */
	public InetAddress getRandomAddress() {
		return addressBook.get(MathUtil.generateRandomNumberWithRange(0,
				addressBook.size() - 1));
	}

	/**
	 * Creates a new address supplier.
	 */
	public MulticastAddressSupplier() {
		this.addressBook = new ArrayList<InetAddress>();
		try {
			addressBook.add(InetAddress.getByName("224.0.0.42"));
			addressBook.add(InetAddress.getByName("224.0.0.43"));
			addressBook.add(InetAddress.getByName("224.0.0.44"));
			addressBook.add(InetAddress.getByName("224.0.0.45"));
			addressBook.add(InetAddress.getByName("224.0.0.46"));
		} catch (UnknownHostException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Adds a custom multicast address that is not in the current list.
	 * 
	 * @param address
	 *            the new multicast address we want to add, if the address isn't
	 *            a multicast address it wont be added to the list of addresses.
	 */
	public void addCustomAddress(InetAddress address) {
		if (address.isMulticastAddress() || !addressBook.contains(address)) {
			addressBook.add(address);
		}
	}
}
