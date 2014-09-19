package com.sirma.itt.javacourse.desingPatterns.task4.objectPool;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class for ObjectPool sesinf pattern example.
 * 
 * @author Simeon Iliev
 */
public class RunUserPool {

	private static Logger log = Logger.getLogger(RunUserPool.class.getName());

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {
		UserPool pool = UserPool.getInstance();
		User user = null;
		while (true) {
			IOUtils.printConsoleMessage("Pool and user operations\n" + " 1: Acquire user\n"
					+ " 2 : release User \n" + " 3 : Set user name\n" + " 4 : Get User name\n"
					+ " 5 : Set Password\n" + " 6 : Get Password\n" + "-1 : Exit");
			int key = IOUtils.readInt();

			switch (key) {
				case 1:
					try {
						user = pool.aquareUser();
					} catch (NoMoreResourcesException e) {
						log.error(e.getMessage(), e);
					}
					break;
				case 2:
					try {
						pool.releseUser(user);
					} catch (NullPointerException e) {
						IOUtils.printConsoleMessage("Please use operation code 1");
						log.error(e.getMessage(), e);
					}
					break;
				case 3:
					try {
						IOUtils.printConsoleMessage("Set user name : ");
						user.setUserName(IOUtils.readLine());
					} catch (NullPointerException e) {
						IOUtils.printConsoleMessage("Please use operation code 1");
						log.error(e.getMessage(), e);
					}
					break;
				case 4:
					try {
						IOUtils.printConsoleMessage("Current user name: " + user.getUserName());
					} catch (NullPointerException e) {
						IOUtils.printConsoleMessage("Please use operation code 1");
						log.error(e.getMessage(), e);
					}
					break;
				case 5:
					try {
						IOUtils.printConsoleMessage("Set user password : ");
						user.setPassword(IOUtils.readLine());
					} catch (NullPointerException e) {
						IOUtils.printConsoleMessage("Please use operation code 1");
						log.error(e.getMessage(), e);
					}
					break;
				case 6:
					IOUtils.printConsoleMessage("Password should not be displayed.");
					break;
				case -1:
					System.exit(0);
					break;
				default:
					IOUtils.printConsoleMessage("Input valid code");
					break;
			}
		}

	}

}
