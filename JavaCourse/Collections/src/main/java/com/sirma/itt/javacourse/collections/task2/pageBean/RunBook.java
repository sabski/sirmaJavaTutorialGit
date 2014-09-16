package com.sirma.itt.javacourse.collections.task2.pageBean;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class for book.
 * 
 * @author simeon
 */
public class RunBook {

	private static Book book;

	/**
	 * Main method for bookClass.
	 * 
	 * @param args
	 *            argument for the main function.
	 */
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		IOUtils.printConsoleMessage("Input the number of element in the book");
		int elCount = IOUtils.readInt();
		for (int i = 0; i < elCount; i++) {
			IOUtils.printConsoleMessage("Input element " + (i + 1));
			list.add(IOUtils.readLine());
		}
		IOUtils.printConsoleMessage("Input the number of objects per page");
		int pageCount = IOUtils.readInt();
		book = new Book(list, pageCount);
		while (true) {
			IOUtils.printConsoleMessage("Menu operations : \n" + "1-Next page\n"
					+ "2-Previous page \n" + "3-First page\n" + "4-Last page\n" + "5-Has next\n"
					+ "6-Has previous\n" + "0-Exit");
			menu(IOUtils.readInt());
		}
	}

	/**
	 * Menu operator function that applies the user selected option.
	 * 
	 * @param code
	 *            the code of the operation.
	 */
	public static void menu(int code) {
		switch (code) {
			case 1:
				try {
					IOUtils.printConsoleMessage(book.next().toString());
				} catch (NullPointerException e) {
					IOUtils.printConsoleMessage("There are no more pages");
				}
				break;
			case 2:
				try {
					IOUtils.printConsoleMessage(book.previous().toString());
				} catch (NullPointerException e) {
					IOUtils.printConsoleMessage("Negative Index");
				}
				break;
			case 3:
				IOUtils.printConsoleMessage(book.firstPage().toString());
				break;
			case 4:
				IOUtils.printConsoleMessage(book.lastPage().toString());
				break;
			case 5:
				IOUtils.printConsoleMessage(book.hasNext() + "");
				break;
			case 6:
				IOUtils.printConsoleMessage(book.hasPrevious() + "");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				IOUtils.printConsoleMessage("Invalid code operation !");
				break;
		}
	}
}
