package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import javax.swing.SwingUtilities;


/**
 * @author Simeon Iliev
 */
public class RunDownloadAgent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	new DownloadAgentGui();
	        }
	      });
	}
}
