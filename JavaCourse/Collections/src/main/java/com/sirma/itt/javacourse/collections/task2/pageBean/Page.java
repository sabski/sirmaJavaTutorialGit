package com.sirma.itt.javacourse.collections.task2.pageBean;

import java.util.List;

/**
 * Page object that is used in book class.
 * 
 * @author simeon
 */
public class Page {

	private List<?> pageContent;

	/**
	 * Getter method for pageContent.
	 * 
	 * @return the pageContent
	 */
	public List<?> getPageContent() {
		return pageContent;
	}

	/**
	 * Setter method for pageContent.
	 * 
	 * @param pageContent
	 *            the pageContent to set
	 */
	public void setPageContent(List<?> pageContent) {
		this.pageContent = pageContent;
	}

	/**
	 * @param pageContent
	 */
	public Page(List<?> pageContent) {
		this.pageContent = pageContent;
	}

}
