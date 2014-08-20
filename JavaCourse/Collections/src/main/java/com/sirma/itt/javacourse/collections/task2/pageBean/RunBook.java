package com.sirma.itt.javacourse.collections.task2.pageBean;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.Utils;

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
		Utils.printConsoleMessage("Input the number of ellement in the book");
		int elCount = Utils.readInt();
		for (int i = 0; i < elCount; i++) {
			Utils.printConsoleMessage("Input ellement " + (i + 1));
			list.add(Utils.readLine());
		}
		Utils.printConsoleMessage("Input the number of objects per page");
		int pageCount = Utils.readInt();
		book = new Book(list, pageCount);
		while (true) {
			Utils.printConsoleMessage("Menu operathions : \n1-nextPage\n2-previousPage \n3-firstPage\n4-lastPage\n5-hasNext\n6-hasPrevious\n0-Exit");
			menu(Utils.readInt());
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
					Utils.printConsoleMessage(book.next().toString());
				} catch (NullPointerException e) {
					Utils.printConsoleMessage("There are no more pages");
				}
				break;
			case 2:
				try {
					Utils.printConsoleMessage(book.previous().toString());
				} catch (NullPointerException e) {
					Utils.printConsoleMessage("Negative Index");
				}
				break;
			case 3:
				Utils.printConsoleMessage(book.firstPage().toString());
				break;
			case 4:
				Utils.printConsoleMessage(book.lastPage().toString());
				break;
			case 5:
				Utils.printConsoleMessage(book.hasNext() + "");
				break;
			case 6:
				Utils.printConsoleMessage(book.hasPrevious() + "");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				Utils.printConsoleMessage("Invalid code operathion !");
				break;
		}
	}
}
