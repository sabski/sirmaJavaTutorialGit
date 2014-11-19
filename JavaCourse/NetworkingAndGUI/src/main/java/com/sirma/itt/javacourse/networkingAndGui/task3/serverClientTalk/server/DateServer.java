package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.Observable;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.Observer;

/**
 * Date server class that is opened on port 7000. This class accepts connections from new clients
 * And sends them the server Date. The class implements the {@link Observable} interface to send
 * Messages to the UI.
 * 
 * @author Simeon Iliev
 */
public class DateServer implements Observable {

	private static Logger log = Logger.getLogger(DateServer.class);

	private ServerSocket server;
	private Socket client;
	private boolean flag;
	private final List<Observer> observers;
	private String lastMassage;

	/**
	 * Basic constructor.
	 */
	public DateServer() {
		observers = new ArrayList<Observer>();
	}

	/**
	 * Opens the server socket. After this method is called the method accepConnection() should be
	 * called, to allow user processing. When the server is started the observers are notified.
	 */
	public void startServer() {
		try {
			server = new ServerSocket(7000);
			flag = true;
			lastMassage = "Server started";
			notifyObservers(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			lastMassage = e.getMessage();
			notifyObservers(null);
		}
	}

	/**
	 * Stops the server by closing the connection and stopping the admission of new clients to the
	 * server. Notifies the observers that the server has stopped or if didn't stop properly.
	 */
	public void stopServer() {
		if (server != null) {
			try {
				flag = false;
				server.close();
				lastMassage = "Server stopped";
				notifyObservers(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				lastMassage = e.getMessage();
				notifyObservers(null);
			}
		}
	}

	/**
	 * Allows the acceptance of connections for the server. Before this method is called make sure
	 * that the startServer() method is called.
	 */
	public void accepConnection() {
		while (flag) {
			try {
				client = server.accept();
			} catch (IOException e) {
				lastMassage = e.getMessage();
				notifyObservers(null);
			}
			if (flag) {
				new DateServerThread(client).start();
				lastMassage = "New client";
				notifyObservers(null);
			}
		}
	}

	/**
	 * Getter method for lastMassage.
	 * 
	 * @return the lastMassage
	 */
	public String getLastMassage() {
		return lastMassage;
	}

	/**
	 * Setter method for lastMassage.
	 * 
	 * @param lastMassage
	 *            the lastMassage to set
	 */
	public void setLastMassage(String lastMassage) {
		this.lastMassage = lastMassage;
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
