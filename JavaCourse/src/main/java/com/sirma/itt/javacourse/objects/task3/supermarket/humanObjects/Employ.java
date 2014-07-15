package com.sirma.itt.javacourse.objects.task3.supermarket.humanObjects;

import java.util.ArrayList;

/**
 * Employ of the supermarket.
 * 
 * @author simeon
 */
public class Employ extends Human {

	private float salary;
	private String station;
	private ArrayList<Employ> manages = null;

	/**
	 * Getter method for salary.
	 * 
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * Setter method for salary.
	 * 
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	/**
	 * Getter method for station.
	 * 
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * Setter method for station.
	 * 
	 * @param station
	 *            the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * Getter method for manages.
	 * 
	 * @return the manages
	 */
	public ArrayList<Employ> getManages() {
		return manages;
	}

	/**
	 * Setter method for manages.
	 * 
	 * @param manages
	 *            the manages to set
	 */
	public void setManages(ArrayList<Employ> manages) {
		this.manages = manages;
	}

	/**
	 * @param name
	 *            the name of the employ
	 * @param egn
	 *            the EGN of the employ
	 * @param address
	 *            the address of the employ
	 * @param gender
	 *            the gender of the employ
	 * @param salary
	 *            the salary of the employ
	 * @param station
	 *            the work station of the employ
	 */
	public Employ(String name, String egn, String address, boolean gender, float salary,
			String station) {
		super(name, egn, address, gender);
		this.salary = salary;
		this.station = station;
	}

}
