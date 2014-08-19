package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;

/**
 * Class for running the classinit sample.
 * 
 * @author simeon
 */
public class RunClassInit {

	/**
	 * Main method of the application.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {

		ClassInit init = new ClassInit();
		try {
			init.getClassHierhahyAndInterfaces("java.lang.String");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
