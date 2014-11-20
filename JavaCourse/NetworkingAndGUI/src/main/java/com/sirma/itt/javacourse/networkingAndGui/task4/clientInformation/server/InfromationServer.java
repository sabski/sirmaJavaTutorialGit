package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.Observable;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.Observer;

/**
 * @author Simeon Iliev
 */
public class InfromationServer implements Observable {

	private static Logger log = Logger.getLogger(InfromationServer.class);

	private ServerSocket server;
	private Socket client;
	private int clientNumber;
	private boolean isRunning;
	private final List<Socket> clientList;
	private final List<Observer> observers;

	/**
	 * 
	 */
	public InfromationServer() {
		this.clientNumber = 0;
		this.clientList = new ArrayList<Socket>();
		observers = new ArrayList<Observer>();

	}

	public void startServer() {
		try {
			server = new ServerSocket(7000);
			setRunning(true);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void stopServer() {
		if (server != null) {
			try {
				server.close();
				clientNumber = 0;
				clientList.clear();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public void acceptConnetion() {
		while (isRunning()) {
			try {
				client = server.accept();
				clientNumber++;
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
			new InformationThread(clientList, clientNumber).start();
			clientList.add(client);
		}
	}

	/**
	 * Getter method for isRunning.
	 * 
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Setter method for isRunning.
	 * 
	 * @param isRunning
	 *            the isRunning to set
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void dettachObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Observable observable) {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	@Override
	public int getObserverCount() {
		return observers.size();
	}
}
