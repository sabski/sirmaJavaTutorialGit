package com.sirma.itt.javacourse.collections.task2.pageBean;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.InputUtils;

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
		InputUtils.printConsoleMessage("Input the number of element in the book");
		int elementCount = InputUtils.readInt();
		for (int i = 0; i < elementCount; i++) {
			InputUtils.printConsoleMessage("Input element " + (i + 1));
			list.add(InputUtils.readLine());
		}
		InputUtils.printConsoleMessage("Input the number of objects per page");
		int pageCount = InputUtils.readInt();
		book = new Book(list, pageCount);
		while (true) {
			InputUtils.printConsoleMessage("Menu operations : \n" + "1-Next page\n"
					+ "2-Previous page \n" + "3-First page\n" + "4-Last page\n" + "5-Has next\n"
					+ "6-Has previous\n" + "0-Exit");
			menu(InputUtils.readInt());
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
					InputUtils.printConsoleMessage(book.next().toString());
				} catch (NullPointerException e) {
					InputUtils.printConsoleMessage("There are no more pages");
				}
				break;
			case 2:
				try {
					InputUtils.printConsoleMessage(book.previous().toString());
				} catch (NullPointerException e) {
					InputUtils.printConsoleMessage("Negative Index");
				}
				break;
			case 3:
				InputUtils.printConsoleMessage(book.firstPage().toString());
				break;
			case 4:
				InputUtils.printConsoleMessage(book.lastPage().toString());
				break;
			case 5:
				InputUtils.printConsoleMessage(book.hasNext() + "");
				break;
			case 6:
				InputUtils.printConsoleMessage(book.hasPrevious() + "");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				InputUtils.printConsoleMessage("Invalid code operation !");
				break;
		}
	}
}
