package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

/**
 * Simple class only used to test annotation sorting.
 * 
 * @author simeon
 */
@SortingAnotation(weight = 2)
public class ChildAClass extends ParrentClass {

	/**
	 * @param id
	 *            id of the object.
	 * @param msg
	 *            message
	 */
	public ChildAClass(int id, String msg) {
		super(id);
		this.msg = msg;
	}

	private String msg = "ChildAClass";

	/**
	 * Getter method for msg.
	 * 
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Setter method for msg.
	 * 
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
