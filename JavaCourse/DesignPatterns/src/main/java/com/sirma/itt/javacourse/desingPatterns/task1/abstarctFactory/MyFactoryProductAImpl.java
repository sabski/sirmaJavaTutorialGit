package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Another {@link MyFactoryProduct}
 * 
 * @author Simeon Iliev
 */
public class MyFactoryProductAImpl implements MyFactoryProduct {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String saySomething(String something) {
		IOUtils.printConsoleMessage("MyFactoryProductAImpl :" + something);
		return something;
	}

}
