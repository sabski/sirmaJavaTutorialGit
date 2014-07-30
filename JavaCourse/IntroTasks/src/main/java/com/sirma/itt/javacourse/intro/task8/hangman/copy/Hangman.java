package com.sirma.itt.javacourse.intro.task8.hangman.copy;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for playing the hang man game.
 * 
 * @author simeon
 */
public class Hangman {

	private String word = "apple";
	private String view = "*****";
	private String winGame = "You win  you guest the word : " + word;
	private String youLose = "You lose";
	private String guesTheWord = "Gues the word " + view;
	private String inputword = "Input word or leather";

	private int counter = 0;

	/**
	 * Starts a new hang man game.
	 */
	public void newGame() {

		Utils.printConsoleMessage(guesTheWord);

		while (counter != 5) {
			Utils.printConsoleMessage(inputword);
			String line = Utils.readLine();
			if (line.length() > 1) {
				if (checkWord(line, word)) {
					Utils.printConsoleMessage(winGame);
					break;
				} else {
					counter++;
					Utils.printConsoleMessage("You have " + (5 - counter) + " tries left");
				}
			} else {
				if (!chekLether(line, word)) {
					counter++;
					Utils.printConsoleMessage("You have " + (5 - counter) + " tries left");
				}
				if (checkWord(view, word)) {
					Utils.printConsoleMessage(winGame);
					break;
				}
			}
		}
		if (counter == 5) {
			Utils.printConsoleMessage(youLose);
		}
	}

	/**
	 * Checks if the user entered the word correctly.
	 * 
	 * @param gues
	 *            the user input.
	 * @param word
	 *            the word to match.
	 * @return true if the user quest the word.
	 */
	public boolean checkWord(String gues, String word) {

		return gues.equals(word);
	}

	/**
	 * Checks if the letter entered by the user is in the word.
	 * 
	 * @param leather
	 *            the leather to be checked.
	 * @param word
	 *            the word that is to checked.
	 * @return true if there is a matching letter otherwise return false.
	 */
	public boolean chekLether(String leather, String word) {

		int lenght = word.length();
		char[] temp = view.toCharArray();
		char[] word2 = word.toCharArray();
		for (int i = 0; i < lenght; i++) {
			Character a = word2[i];
			if (a.equals(leather.charAt(0))) {
				temp[i] = leather.charAt(0);
			}
		}
		view = new String(temp);
		Utils.printConsoleMessage(view);
		return word.contains(leather);
	}

}
