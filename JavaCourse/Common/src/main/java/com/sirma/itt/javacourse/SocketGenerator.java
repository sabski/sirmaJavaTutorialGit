package com.sirma.itt.javacourse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**
 * Creates {@link Socket} and {@link ServerSocket} at default ports and host.Can
 * also create them at custom host and ports.
 * 
 * @author siliev
 * 
 */
public class SocketGenerator {

	/**
	 * Default minimal searching port.
	 */
	public final static int MIN_PORT = 7000;

	/**
	 * Default maximal searching port.
	 */
	public final static int MAX_PORT = 7020;

	/**
	 * Default host address.
	 */
	public final static String HOST_ADDRESS = "localhost";

	private final static Logger LOGGER = Logger.getLogger(SocketGenerator.class);

	/**
	 * Creates a new {@link Socket} at {@value #HOST_ADDRESS} at a single port
	 * ranging from {@value #MIN_PORT} to {@value #MAX_PORT}.
	 * 
	 * @return a new {@link Socket} or null if all the ports on
	 *         {@value #HOST_ADDRESS} from {@value #MIN_PORT} to
	 *         {@value #MAX_PORT} are in use.
	 */
	public static Socket createSocket() {
		return createSocket(HOST_ADDRESS, MIN_PORT, MAX_PORT);
	}

	/**
	 * Creates a new {@link Socket} at a specified host at a single port ranging
	 * from minPort to maxPort.
	 * 
	 * @param host
	 *            the host address we want to connect to.
	 * @param minPort
	 *            the minimal port value we want are {@link Socket} to be.
	 * @param maxPort
	 *            the maximum port value we want are {@link Socket} to be.
	 * @return a new {@link Socket} or null if the host name is invalid or there
	 *         is no available port.
	 */
	public static Socket createSocket(String host, int minPort, int maxPort) {
		Socket client = null;
		for (int i = minPort; i < maxPort; i++) {
			try {
				client = createSocket(host, i);
				break;
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return client;
	}

	/**
	 * Creates a new {@link Socket} at a specified host and port.
	 * 
	 * @param host
	 *            the host address we want to connect to.
	 * @param port
	 *            the port number we want to connect.
	 * @return the new {@link Sockets}
	 * @throws UnknownHostException
	 *             if the host address is incorrect or can`t be located.
	 * @throws IOException
	 *             IDK.
	 */
	public static Socket createSocket(String host, int port)
			throws UnknownHostException, IOException {
		return new Socket(host, port);
	}

	/**
	 * Creates a new {@link ServerSocket} from a specified range from
	 * {@value #MIN_PORT} to {@value #MAX_PORT}.
	 * 
	 * @return a new {@link ServerSocket} or null if a socket was unnable to be
	 *         created.
	 */
	public static ServerSocket createServerSocket() {
		return createServerSocket(MIN_PORT, MAX_PORT);
	}

	/**
	 * Searches a specified port range for available ports and returns the first
	 * created {@link ServerSocket}.
	 * 
	 * @param minPort
	 *            the starting port to start the search.
	 * @param maxPort
	 *            the last we are going to search.
	 * @return the first created {@link ServerSocket} or null if there is no
	 *         available port.
	 */
	public static ServerSocket createServerSocket(int minPort, int maxPort) {
		ServerSocket server = null;
		for (int i = minPort; i <= maxPort; i++) {
			try {
				server = createServerSocket(i);
				break;
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return server;
	}

	/**
	 * Creates a new server socket on a specified port.
	 * 
	 * @param port
	 *            the port we want to {@link ServerSocket} created on.
	 * @return a new {@link ServerSocket} on the specified port.
	 * @throws IOException
	 *             if the socket cannot be created.
	 */
	public static ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(port);
	}
}
