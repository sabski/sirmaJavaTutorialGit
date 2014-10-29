package com.sirma.itt.javacourse.relectionAnotationRegex.test.task3.privateAccess;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess.MyPrivateClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess.ClassInformer;

/**
 * Test class for ClassInformer class to test the reflection of private variables and methods.
 * 
 * @author simeon
 */
public class PrivateReflectorTest {

	private static Logger log = Logger.getLogger(PrivateReflectorTest.class);
	private ClassInformer reflector;
	private MyPrivateClass privateClass;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		reflector = new ClassInformer();
		privateClass = new MyPrivateClass(12, "", 123f);

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess.ClassInformer#breakPrivateFields(java.lang.Object[])}
	 * .
	 */
	@Test
	public void testBreakPrivateFields() {
		try {
			reflector.showPrivateFields(privateClass, "Param");
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}

	}

}
