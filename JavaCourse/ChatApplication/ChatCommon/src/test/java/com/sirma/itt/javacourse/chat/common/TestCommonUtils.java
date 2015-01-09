/**
 * 
 */
package com.sirma.itt.javacourse.chat.common;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;

/**
 * Test class for {@link CommonUtils}
 * 
 * @author siliev
 * 
 */
public class TestCommonUtils {

	/**
	 * Test method to test {@link CommonUtils} splitting method.
	 */
	@Test
	public void test() {
		String[] result = { "t", "e", "s", "t", "1" };
		assertArrayEquals(result, CommonUtils.splitList("[t, e, s, t, 1]"));
	}

}
