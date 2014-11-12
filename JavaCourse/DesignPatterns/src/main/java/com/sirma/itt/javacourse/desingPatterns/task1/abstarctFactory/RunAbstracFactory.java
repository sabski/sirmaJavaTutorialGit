package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Main class for running an abstract factory design pattern.
 * 
 * @author Simeon Iliev
 */
public class RunAbstracFactory {

	/**
	 * Main method for the application.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		AbstractFactory factory = Factory.getInstance();
		while (true) {
			InputUtils.printConsoleMessage("Create a new Factory product\n1 :  Create new product default Construntor "
					+ "\n2 : Create new product using reflection" + "\n-1 : Exit program");
			int key = InputUtils.readInt();
			switch (key) {
				case 1:
					MyProduct product = factory.createInstance();
					InputUtils.printConsoleMessage("Input message for the product to display");
					product.saySomething(InputUtils.readLine());
					break;
				case 2:
					MyProduct productReflection = factory
							.createInstanceByReflection(MyProduct.class.getCanonicalName());
					InputUtils.printConsoleMessage("Input message for the product to display");
					productReflection.saySomething(InputUtils.readLine());
					break;
				case -1:
					System.exit(0);
					break;
				default:
					InputUtils.printConsoleMessage("Please enter valid code :");
					break;
			}
		}
	}

}
