package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;
/**
 * 
 * @author simeon
 */
@SortingAnotation(weight = 1)
public class ParentClass implements Comparable<ParentClass>{

	
	private int id =1;

	/**
	 * Getter method for id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(ParentClass arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
