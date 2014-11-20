package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingPatterns.task6.observer.Observable;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.Observer;

/**
 * @author Simeon Iliev
 */
public class InformationServerGUI extends JFrame implements Observer {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 2732996645737413793L;

	private static Logger log = Logger.getLogger(InformationServerGUI.class);

	@Override
	public void update(Observable observable) {
		// TODO Auto-generated method stub

	}

}
