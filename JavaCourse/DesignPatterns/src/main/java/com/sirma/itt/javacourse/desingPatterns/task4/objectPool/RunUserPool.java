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
						user = pool.acquireUser();
					} catch (NoMoreResourcesException e) {
						log.error(e.getMessage(), e);
					}
					break;
				case 2:
					pool.releseUser(user);
					break;
				case 3:
					IOUtils.printConsoleMessage("Set user name : ");
					user.setUserName(IOUtils.readLine());
					break;
				case 4:
					IOUtils.printConsoleMessage("Current user name: " + user.getUserName());
					break;
				case 5:
					IOUtils.printConsoleMessage("Set user password : ");
					user.setPassword(IOUtils.readLine());
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
