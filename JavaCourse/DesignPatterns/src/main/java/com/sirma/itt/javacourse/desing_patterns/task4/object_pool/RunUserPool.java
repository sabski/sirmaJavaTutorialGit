package com.sirma.itt.javacourse.desing_patterns.task4.object_pool;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;

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
		log.info("Enter pool capacity : ");
		UserPool<User> pool = new UserPool<User>(InputUtils.readInt(),
				new User());
		User user = null;
		while (true) {
			log.info("Pool and user operations\n" + " 1: Acquire user\n"
					+ " 2 : release User \n" + " 3 : Set user name\n"
					+ " 4 : Get User name\n" + " 5 : Set Password\n"
					+ " 6 : Get Password\n" + "-1 : Exit");
			int key = InputUtils.readInt();

			switch (key) {
			case 1:
				try {
					user = pool.acquire();
				} catch (NoMoreResourcesException e) {
					log.error(e.getMessage(), e);
				}
				break;
			case 2:
				try {
					pool.release(user);
				} catch (NoMoreResourcesException e) {
					log.error(e.getMessage(), e);
				}
				break;
			case 3:
				InputUtils.printConsoleMessage("Set user name : ");
				user.setUserName(InputUtils.readLine());
				break;
			case 4:
				InputUtils.printConsoleMessage("Current user name: "
						+ user.getUserName());
				break;
			case 5:
				InputUtils.printConsoleMessage("Set user password : ");
				user.setPassword(InputUtils.readLine());
				break;
			case 6:
				InputUtils
						.printConsoleMessage("Password should not be displayed.");
				break;
			case -1:
				System.exit(0);
				break;
			default:
				InputUtils.printConsoleMessage("Input valid code");
				break;
			}
		}

	}

}
