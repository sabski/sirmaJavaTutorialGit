/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.ui.componnents;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author siliev
 * 
 */
public class LimitTextField extends PlainDocument {
	private static final long serialVersionUID = 1402603494725444011L;
	private int limit;

	public LimitTextField(int limit) {
		super();
		this.limit = limit;
	}

	public LimitTextField(int limit, boolean upper) {
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr)
			throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}
