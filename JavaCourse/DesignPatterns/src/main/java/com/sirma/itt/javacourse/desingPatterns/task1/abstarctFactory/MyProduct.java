package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Factory product implementation {@link MyProduct}
 * 
 * @author Simeon Iliev
 */
public class MyProduct {

	private String comment;

	public String saySomething(String something) {
		InputUtils.printConsoleMessage(something);
		return something;
	}

	/**
	 * First constructor.
	 * 
	 * @param comment
	 *            the comment we want to add.
	 */
	public MyProduct(String comment) {
		this.comment = comment;
	}

	/**
	 * Default constructor.
	 */
	public MyProduct() {
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
