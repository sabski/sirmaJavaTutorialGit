package comsirma.itt.javacourse.inputOutput.test.task6.serializathion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.ReflectionUtil;
import com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject;

/**
 * JUnit test for {@link com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject}
 * 
 * @author Simeon Iliev
 */
public class TestSerializathion {

	private UserDefinedObject object;
	private String path = "src/test/resources/Serializathion.txt";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object = new UserDefinedObject(2222, "Hello");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject#saveObject(java.lang.String, com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject)}
	 * .
	 */
	@Test
	public void testSaveObject() {
		object.saveObject(path, object);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject#getObject(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetObject() {
		try {
			assertTrue(ReflectionUtil.compareObjects(object, object.getObject(path)));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject#saveObject(java.lang.String, com.sirma.itt.javacourse.inputoutput.task6.serialization.UserDefinedObject)}
	 * . Test with null object.
	 */
	@Test
	public void testSaveObjectNull() {
		assertFalse(object.saveObject(path, null));
	}

}
