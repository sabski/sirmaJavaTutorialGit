/**
 * 
 */
package com.sirma.itt.javacourse;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

import org.apache.log4j.Logger;

/**
 * @author siliev
 * 
 */
public class SocketGenerator {

	public final static int MIN_PORT = 7000;
	public final static int MAX_PORT = 7020;
	public final static String HOST_ADDRESS = "localhost";

	private final static Logger log = Logger.getLogger(SocketGenerator.class);

	public static Socket createSocket() {
		return createSocket(HOST_ADDRESS, MIN_PORT, MAX_PORT);
	}

	public static Socket createSocket(String host, int minPort, int maxPort) {
		Socket client = null;
		for (int i = minPort; i < maxPort; i++) {
			try {
				client = createSocket(host, i);
				break;
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return client;
	}

	public static Socket createSocket(String host, int port)
			throws UnknownHostException, IOException {
		return new Socket(host, port);
	}

	public static ServerSocket createServerSocket() {
		return createServerSocket(MIN_PORT, MAX_PORT);
	}

	public static ServerSocket createServerSocket(int minPort, int maxPort) {
		ServerSocket server = null;
		for (int i = minPort; i < maxPort; i++) {
			try {
				server = createServerSocket(i);
				break;
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return server;
	}

	public static ServerSocket createServerSocket(int port) throws IOException {

		return new ServerSocket(port);
	}
}
