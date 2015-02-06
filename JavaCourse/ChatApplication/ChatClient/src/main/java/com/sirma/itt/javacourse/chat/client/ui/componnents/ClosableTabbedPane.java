package com.sirma.itt.javacourse.chat.client.ui.componnents;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTabbedPane;

/**
 * Closable tabbed pane.
 * 
 * @author Simon Iliev
 * 
 */
public class ClosableTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 3867900688880839110L;

	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger
			.getLogger(ClosableTabbedPane.class);

	private TabCloseUI closeUI = new TabCloseUI(this);

	public void paint(Graphics g) {
		super.paint(g);
		closeUI.paint(g);
	}

	public void addTab(String title, Component component) {
		super.addTab(title + "  ", component);
	}

	public String getTabTitleAt(int index) {
		return super.getTitleAt(index).trim();
	}

	public boolean tabAboutToClose(int tabIndex) {
		return true;
	}

	public boolean containsComponnent(Component component) {
		Component[] components = this.getComponents();
		List<Component> c = Arrays.asList(components);
		return c.contains(component);
	}

	/**
	 * Checks if the component should add a symbol to notify the user of a
	 * message.
	 * 
	 * @param component
	 *            the component we want to check if is on focus.
	 */
	public void shoudNotifyUser(Component component) {
		LOGGER.info("is showing : " + component.isShowing());
		int index = indexOfComponent(component);
		if (!component.isShowing()) {
			closeUI.notifyUser(true, index);
		}
	}
}
