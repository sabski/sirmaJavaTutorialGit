package com.sirma.itt.javacourse.inputoutput.task6.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sirma.itt.javacourse.Utils;

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
		super();
		this.myNuber = myNuber;
		this.saySomething = saySomething;
	}

	/**
	 * Saves an instance of UserDefinedObject to a specified file.
	 * 
	 * @param path
	 *            the path to the file the user wants to save the object.
	 * @param o
	 *            object to be saved into the file.
	 * @throws IOException
	 *             throw exception if file is not accessible.
	 */
	public boolean saveObject(String path, UserDefinedObject o) {

		if (o == null){
			return false;
		}
		
		File file = new File(path);
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Utils.printConsoleMessage("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			Utils.printConsoleMessage("Input output error");
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {
			fin = new FileInputStream(file);
			ois = new ObjectInputStream(fin);
			result = (UserDefinedObject) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					Utils.printConsoleMessage("Closing streams");
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}
}
