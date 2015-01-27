package com.sirma.itt.javacourse.chat.client.ui.componnents;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.sirma.itt.javacourse.chat.client.ui.ChatWindow;

public class ButtonTabComponent extends JPanel {

	private static final long serialVersionUID = 8527016988106857871L;

	public ButtonTabComponent(final JTabbedPane pane, String text,
			ChatWindow window) {
		// unset default FlowLayout' gaps
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		if (pane == null) {
			throw new NullPointerException("TabbedPane is null");
		}
		setOpaque(false);

		// make JLabel read titles from JTabbedPane
		JLabel label = new JLabel(text);

		add(label);
		// add more space between the label and the button
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		// tab button
		JButton button = new TabComponnent(pane, window);
		add(button);
		// add more space to the top of the component
		setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
	}
}
