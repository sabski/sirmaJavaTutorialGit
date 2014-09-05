package com.sirma.itt.javacourse.collections.task2.pageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Book that displays given content by the user.
 * 
 * @author simeon
 */
public class Book {

	private List<?> content;
	private int pageSize;
	private int index = -1;
	private List<Page> pages;

	/**
	 * Getter method for content.
	 * 
	 * @return the content
	 */
	public List<?> getContent() {
		return content;
	}

	/**
	 * Setter method for content.
	 * 
	 * @param content
	 *            the content to set
	 */
	public void setContent(List<?> content) {
		this.content = content;
	}

	/**
	 * Getter method for pageSize.
	 * 
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Setter method for pageSize.
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Retries the next page if there is one otherwise returns null.
	 * 
	 * @return the next page
	 */
	public List<?> next() {
		if (!hasNext()) {
			return null;
		}
		return getPage(index + 1);
	}

	/**
	 * Retries the previous page if there is one otherwise returns null.
	 * 
	 * @return the previous page.
	 */
	public List<?> previous() {
		if (!hasPrevious()) {
			return null;
		}
		return getPage(index - 1);
	}

	/**
	 * Checks if there is a next page.
	 * 
	 * @return true if there is a next page
	 */
	public boolean hasNext() {
		return pages.size() > (index + 1);
	}

	/**
	 * Checks if there is a previous page.
	 * 
	 * @return true if there is a previous page
	 */
	public boolean hasPrevious() {
		return index >= 1;
	}

	/**
	 * Sets the index of the book to the first page.
	 * 
	 * @return the first page of the book.
	 */
	public List<?> firstPage() {
		index = 0;
		return pages.get(0).getPageContent();
	}

	/**
	 * Sets the index of the book to the last page.
	 * 
	 * @return the last page of the book.
	 */
	public List<?> lastPage() {
		index = pages.size() - 1;
		return pages.get(index).getPageContent();
	}

	/**
	 * Gives the user the page there are currently reading.
	 * 
	 * @return the page number index;
	 */
	public int getCurrentPageNumber() {
		return index + 1;
	}

	/**
	 * Retrieves a specific page. And places the index pointer to the last page that was returned by
	 * this method.
	 * 
	 * @param i
	 *            the number of the page.
	 * @return the page at number i.
	 */
	public List<?> getPage(int i) {
		index = i;
		return pages.get(i).getPageContent();
	}

	/**
	 * @param content
	 *            the List of items that are going to be the contents of the book.
	 * @param pageSize
	 *            the number of objects that are going to be represent on a single page.
	 */
	public Book(List<?> content, int pageSize) {
		this.content = content;
		this.pageSize = pageSize;
		updateContent();
	}

	/**
	 * Getter method for pages.
	 * 
	 * @return the pages
	 */
	public List<Page> getPages() {
		return pages;
	}

	/**
	 * Setter method for pages.
	 * 
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	/**
	 * Updates the book content.
	 */
	public void updateContent() {
		pages = new ArrayList<Page>(content.size() / pageSize);
		Page page;
		for (int i = 1; i <= content.size() / pageSize; i++) {
			page = new Page(content.subList((i * pageSize - pageSize), i * pageSize));
			pages.add(page);
		}
		if (content.size() > pages.size() * pageSize) {
			page = new Page(content.subList((pages.size() * pageSize), content.size()));
			pages.add(page);
		}
	}
}
