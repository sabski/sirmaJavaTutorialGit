package com.sirma.itt.javacourse.desing_patterns.task5.proxy;

/**
 * Car object that will be proxyed.
 * 
 * @author Simeon Iliev
 */
public class Car implements CarInterface {

	private String model;
	private String brand;
	private int horsePower;
	private int fuellUssage;

	/**
	 * Getter method for model.
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Setter method for model.
	 * 
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Getter method for brand.
	 * 
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter method for brand.
	 * 
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter method for horsePower.
	 * 
	 * @return the horsePower
	 */
	public int getHorsePower() {
		return horsePower;
	}

	/**
	 * Setter method for horsePower.
	 * 
	 * @param horsePower
	 *            the horsePower to set
	 */
	public void setHorsePower(int hoursePower) {
		this.horsePower = hoursePower;
	}

	/**
	 * Getter method for fuellUssage.
	 * 
	 * @return the fuellUssage
	 */
	public int getFuellUsaage() {
		return fuellUssage;
	}

	/**
	 * Setter method for fuellUssage.
	 * 
	 * @param fuellUssage
	 *            the fuellUsaage to set
	 */
	public void setFuellUsaage(int fuellUssage) {
		this.fuellUssage = fuellUssage;
	}

	@Override
	public void setUpCar(String model, String brand, int horsePower, int fuellUssage) {
		setBrand(brand);
		setFuellUsaage(fuellUssage);
		setHorsePower(horsePower);
		setModel(model);
	}

	@Override
	public String getBrandAndModel() {
		return "Brand : " + getBrand() + "Model : " + getModel();
	}

}
