package com.sirma.itt.javacourse.objects.task3.supermarket.humanObjects;

/**
 * Client class for the supermarket.
 * 
 * @author simeon
 */
public class Client extends Human {

	private int clientID;

	/**
	 * Getter method for clientID.
	 * 
	 * @return the clientID
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * Setter method for clientID.
	 * 
	 * @param clientID
	 *            the clientID to set
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * Constructor for a client.
	 * 
	 * @param name
	 *            the name of the client
	 * @param egn
	 *            the EGN of the client
	 * @param address
	 *            the Address of the client
	 * @param gender
	 *            the gender of the client
	 * @param clientID
	 *            the unique client ID number
	 */
	public Client(String name, String egn, String address, boolean gender, int clientID) {
		super(name, egn, address, gender);
		// TODO Auto-generated constructor stub
		this.clientID = clientID;
	}

}
