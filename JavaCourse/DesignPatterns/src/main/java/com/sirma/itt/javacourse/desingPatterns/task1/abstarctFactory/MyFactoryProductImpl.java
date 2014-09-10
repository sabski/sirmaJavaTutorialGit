package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Factory product implementation {@link MyFactoryProduct}
 * 
 * @author Simeon Iliev
 */
public class MyFactoryProductImpl implements MyFactoryProduct {

	private String comment;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String saySomething(String something) {
		IOUtils.printConsoleMessage(something);
		return something;
	}

	/**
	 * First constructor.
	 * 
	 * @param comment
	 *            the comment we want to add.
	 */
	public MyFactoryProductImpl(String comment) {
		this.comment = comment;
	}

	/**
	 * Default constructor.
	 */
	public MyFactoryProductImpl() {
	}

	/**
	 * Getter method for comment.
	 * 
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Setter method for comment.
	 * 
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
