package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import com.sirma.itt.javacourse.IOUtils;

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
		MyFactory factory = MyFactoryImpl.getInstance();
		MyFactory factoryA = MyFactoryAImpl.getInstance();
		while (true) {
			IOUtils.printConsoleMessage("Create a new Factory product\n1 :  Create new product default Construntor "
					+ "\n2 : Create new product using reflection"
					+ "\n3 : Create new product type A using reflection"
					+ "\n4 : Create new product type A using reflection " + "\n-1 : Exit program");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					MyFactoryProduct product = factory.createInstance();
					IOUtils.printConsoleMessage("Input message for the product to display");
					product.saySomething(IOUtils.readLine());
					break;
				case 2:
					MyFactoryProduct productReflection = factory.createInstanceByReflection();
					IOUtils.printConsoleMessage("Input message for the product to display");
					productReflection.saySomething(IOUtils.readLine());
					break;
				case 3:
					MyFactoryProduct productA = factoryA.createInstanceByReflection();
					IOUtils.printConsoleMessage("Input message for the product to display");
					productA.saySomething(IOUtils.readLine());
					break;
				case 4:
					MyFactoryProduct productAReflection = factoryA.createInstanceByReflection();
					IOUtils.printConsoleMessage("Input message for the product to display");
					productAReflection.saySomething(IOUtils.readLine());
					break;
				case -1:
					System.exit(0);
					break;
				default:
					IOUtils.printConsoleMessage("Please enter valid code :");
					break;
			}
		}
	}

}
