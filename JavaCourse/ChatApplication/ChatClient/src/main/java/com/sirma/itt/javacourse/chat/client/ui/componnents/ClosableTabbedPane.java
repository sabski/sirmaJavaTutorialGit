package com.sirma.itt.javacourse.chat.client.ui.componnents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTabbedPane;

import com.sirma.itt.javacourse.chat.client.ui.ChatWindow;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

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

	private class TabCloseUI implements MouseListener, MouseMotionListener {
		private ClosableTabbedPane tabbedPane;
		private int closeX = 0, closeY = 0, meX = 0, meY = 0;
		private int selectedTab;
		private final int width = 8, height = 8;
		private Rectangle rectangle = new Rectangle(0, 0, width, height);

		public TabCloseUI(ClosableTabbedPane pane) {
			tabbedPane = pane;
			tabbedPane.addMouseMotionListener(this);
			tabbedPane.addMouseListener(this);
		}

		public void mouseEntered(MouseEvent me) {
		}

		public void mouseExited(MouseEvent me) {
		}

		public void mousePressed(MouseEvent me) {
		}

		public void mouseClicked(MouseEvent me) {
			selectedTab = tabbedPane.getSelectedIndex();
			notifyUser(false, selectedTab);
		}

		public void mouseDragged(MouseEvent me) {
		}

		public void mouseReleased(MouseEvent me) {
			if (closeUnderMouse(me.getX(), me.getY())) {
				boolean isToCloseTab = tabAboutToClose(selectedTab);
				if (isToCloseTab && selectedTab > -1) {
					tabbedPane.removeTabAt(selectedTab);
				}
			}
		}

		public void mouseMoved(MouseEvent me) {
			meX = me.getX();
			meY = me.getY();
			if (mouseOverTab(meX, meY)) {
				controlCursor();
				tabbedPane.repaint();
			}
		}

		private void controlCursor() {
			if (tabbedPane.getTabCount() > 0)
				if (closeUnderMouse(meX, meY)) {
					tabbedPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
					if (selectedTab > -1)
						tabbedPane.setToolTipTextAt(selectedTab, "Close "
								+ tabbedPane.getTitleAt(selectedTab));
				} else {
					tabbedPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					if (selectedTab > -1)
						tabbedPane.setToolTipTextAt(selectedTab, "");
				}
		}

		private boolean closeUnderMouse(int x, int y) {
			rectangle.x = closeX;
			rectangle.y = closeY;
			return rectangle.contains(x, y);
		}

		public void paint(Graphics g) {

			int tabCount = tabbedPane.getTabCount();
			for (int j = 0; j < tabCount; j++)
				if (tabbedPane.getComponent(j).isShowing()) {
					int x = tabbedPane.getBoundsAt(j).x
							+ tabbedPane.getBoundsAt(j).width - width - 5;
					int y = tabbedPane.getBoundsAt(j).y + 5;
					drawClose(g, x, y);
					break;
				}
			if (mouseOverTab(meX, meY)) {
				drawClose(g, closeX, closeY);
			}
		}

		private void drawClose(Graphics g, int x, int y) {
			if (tabbedPane != null && tabbedPane.getTabCount() > 0) {
				Graphics2D g2 = (Graphics2D) g;
				drawColored(g2, isUnderMouse(x, y) ? Color.RED : Color.WHITE,
						x, y);
			}
		}

		private void drawColored(Graphics2D g2, Color color, int x, int y) {
			g2.setStroke(new BasicStroke(5, BasicStroke.JOIN_ROUND,
					BasicStroke.CAP_ROUND));
			g2.setColor(Color.BLACK);
			g2.drawLine(x, y, x + width, y + height);
			g2.drawLine(x + width, y, x, y + height);
			g2.setColor(color);
			g2.setStroke(new BasicStroke(3, BasicStroke.JOIN_ROUND,
					BasicStroke.CAP_ROUND));
			g2.drawLine(x, y, x + width, y + height);
			g2.drawLine(x + width, y, x, y + height);

		}

		private boolean isUnderMouse(int x, int y) {
			if (Math.abs(x - meX) < width && Math.abs(y - meY) < height)
				return true;
			return false;
		}

		private boolean mouseOverTab(int x, int y) {
			int tabCount = tabbedPane.getTabCount();
			for (int j = 0; j < tabCount; j++)
				if (tabbedPane.getBoundsAt(j).contains(meX, meY)) {
					selectedTab = j;
					closeX = tabbedPane.getBoundsAt(j).x
							+ tabbedPane.getBoundsAt(j).width - width - 5;
					closeY = tabbedPane.getBoundsAt(j).y + 5;
					return true;
				}
			return false;
		}

		/**
		 * Adds or removes a symbol to the title of the tabs to notify users of
		 * message event if the tab component is not on focus.
		 * 
		 * @param blinkFlag
		 *            flag that tell the component if it should notify user.
		 * @param index
		 *            the index of the element.
		 */
		private void notifyUser(boolean blinkFlag, int index) {
			Component component = tabbedPane.getComponentAt(index);
			ChatWindow window = (ChatWindow) component;
			if (blinkFlag) {
				if (index == 0) {
					tabbedPane.setTitleAt(index,
							LanguageController.getWord("commonroom") + " *");
				} else {
					tabbedPane.setTitleAt(index, window.getUserNames()
							.toString() + " *");
				}
			} else {
				if (index == 0) {
					tabbedPane.setTitleAt(index,
							LanguageController.getWord("commonroom"));
				} else {
					tabbedPane.setTitleAt(index, window.getUserNames()
							.toString());
				}
			}
			tabbedPane.repaint();
		}
	}
}
