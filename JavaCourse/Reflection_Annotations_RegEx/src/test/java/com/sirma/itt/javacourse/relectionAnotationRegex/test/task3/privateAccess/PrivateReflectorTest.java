package com.sirma.itt.javacourse.relectionAnotationRegex.test.task3.privateAccess;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess.MyPrivateClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess.PrivateReflector;

/**
 * Test class for PrivateReflector class to test the reflection of private variables and methods.
 * 
 * @author simeon
 */
public class PrivateReflectorTest {

	private PrivateReflector reflector;
	private MyPrivateClass privateClass;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		reflector = new PrivateReflector();
		privateClass = new MyPrivateClass();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess.PrivateReflector#breakPrivateFields(java.lang.Object[])}
	 * .
	 */
	@Test
	public void testBreakPrivateFields() {

		try {
			reflector.breakPrivateFields(privateClass);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
