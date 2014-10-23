package com.sirma.itt.javacourse.inputoutput.task6.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * Class that stores some data and can be serialized.
 * 
 * @author simeon
 */
public class UserDefinedObject implements Serializable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private final Logger log = Logger.getLogger(UserDefinedObject.class.getName());

	private int myNuber;

	private String saySomething;

	/**
	 * Getter method for myNuber.
	 * 
	 * @return the myNuber
	 */
	public int getMyNuber() {
		return myNuber;
	}

	/**
	 * Setter method for myNuber.
	 * 
	 * @param myNuber
	 *            the myNuber to set
	 */
	public void setMyNuber(int myNuber) {
		this.myNuber = myNuber;
	}

	/**
	 * Getter method for saySomething.
	 * 
	 * @return the saySomething
	 */
	public String getSaySomething() {
		return saySomething;
	}

	/**
	 * Setter method for saySomething.
	 * 
	 * @param saySomething
	 *            the saySomething to set
	 */
	public void setSaySomething(String saySomething) {
		this.saySomething = saySomething;
	}

	/**
	 * Constructor for my data class objects.
	 * 
	 * @param myNuber
	 *            number for contacts.
	 * @param saySomething
	 *            say something to the programmer.
	 */
	public UserDefinedObject(int myNuber, String saySomething) {
		this.myNuber = myNuber;
		this.saySomething = saySomething;
	}

	/**
	 * Saves an instance of UserDefinedObject to a specified file.
	 * 
	 * @param path
	 *            the path to the file the user wants to save the object.
	 * @param object
	 *            object to be saved into the file.
	 * @throws IOException
	 *             throw exception if file is not accessible.
	 */
	public boolean saveObject(String path, UserDefinedObject object) {
		if (object == null) {
			return false;
		}
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		try (FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fout);) {
			oos.writeObject(object);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return true;
	}

	/**
	 * Retries a object instance from a specified File.
	 * 
	 * @param path
	 *            the path to the file
	 * @return the object that was stored in the file (one object)
	 * @throws IOException
	 *             if the file can`t be read
	 */
	public UserDefinedObject getObject(String path) throws IOException {
		UserDefinedObject result = null;
		File file = new File(path);
		try (FileInputStream fin = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fin);) {
			result = (UserDefinedObject) ois.readObject();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
}
