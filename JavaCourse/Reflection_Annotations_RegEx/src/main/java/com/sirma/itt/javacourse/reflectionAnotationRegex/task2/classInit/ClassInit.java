package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;

import java.io.ObjectInputStream.GetField;

import com.sirma.itt.javacourse.Utils;

/**
 * Inits a class by its name and shows his parents.
 * 
 * @author simeon
 */
public class ClassInit {


	public void getClassHierhahyAndInterfaces(String path){

		try {
			Class<?> init = Class.forName(path);
			Object obj = init.newInstance();
			for (Class<?> c : init.getDeclaredClasses()){
				Utils.printConsoleMessage(c.getName());
			}
			
			for(Class<?> c : init.getInterfaces()){
				Utils.printConsoleMessage(c.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
