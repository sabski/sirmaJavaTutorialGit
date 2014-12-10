package com.sirma.itt.javacourse.chat.client.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.utils.UIColegue;

/**
 * 
 * @author siliev
 *
 */
public class ChatsPanel extends JPanel implements UIColegue{

	private static final long serialVersionUID = -3781827111159603799L;

	private static Logger log = Logger.getLogger(ChatsPanel.class);
	private JTabbedPane tabbedPane;
	private int index = 0;

	/**
	 * Constructor
	 */
	public ChatsPanel() {

		setUp();
	}

	private void setUp() {
		// TODO Full set up off the tabbed pane.
		tabbedPane = new JTabbedPane();
		JPanel papel = this;
		papel.setVisible(true);
		papel.add(tabbedPane);

	}

	public void addNewTab(String info) {
		log.info("Adding tab");
		tabbedPane.add(createNewPanel(info), 0);
		tabbedPane.invalidate();

	}

	private JPanel createNewPanel(String info) {
		JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		return panel;
	}

	@Override
	public void sendUIEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerComponent() {
		// TODO Auto-generated method stub
		
	}
}
