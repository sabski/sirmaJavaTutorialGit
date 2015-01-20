package com.sirma.itt.javacourse.chat.client.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.chat.common.utils.LANGUAGES;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.desingpatterns.task6.observer.Observable;
import com.sirma.itt.javacourse.desingpatterns.task6.observer.Observer;

public class LanguageListener implements ActionListener, Observable {

	private List<Observer> observers = new ArrayList<Observer>();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (LanguageController.getCurrentLanguage().equals(
				LANGUAGES.BG.toString())) {
			LanguageController.setLanguage(LANGUAGES.EN.toString());
		} else {
			LanguageController.setLanguage(LANGUAGES.BG.toString());
		}
		displayMessage(null);
	}

	@Override
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void dettachObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void displayMessage(Observable observable) {
		for (Observer observer : observers) {
			observer.update(observable);
		}
	}

	@Override
	public int getObserverCount() {
		return observers.size();
	}

}
