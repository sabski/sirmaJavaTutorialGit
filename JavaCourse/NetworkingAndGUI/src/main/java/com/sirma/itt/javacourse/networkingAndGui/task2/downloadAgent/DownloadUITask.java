package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.inputoutput.task4.transferingObjects.TransferObject;

/**
 * This class extends {@link SwingWorker} to allow the download of files in a
 * background thread.
 * 
 * @author Simeon Iliev
 */
public class DownloadUITask extends SwingWorker<Void, Void> {

	private static final Logger LOGGER = Logger.getLogger(DownloadUITask.class);
	private final String url;
	private final String saveLocation;
	private final JProgressBar progressBar;
	private long downloaded = 0;
	private long fileSize = 0;
	private URL downloadURL;
	private URLConnection connection;
	private TransferObject transporter;

	@Override
	protected Void doInBackground() throws Exception {
		progressBar.setValue(0);
		connection = openConnection();
		/*
		 * LOGGER.info("The length of the content : " +
		 * humanReadableByteCount(connection.getContentLength()));
		 */
		fileSize = connection.getContentLengthLong();
		LOGGER.info("File size " + fileSize);
		String fileName = FilenameUtils.getBaseName(url) + "."
				+ FilenameUtils.getExtension(url);
		if (fileName.equals(".")) {
			showErrorMessage();
			return null;
		}
		if (!new File(saveLocation).exists()) {
			new File(saveLocation).mkdir();
		}
		File file = new File(saveLocation
				+ System.getProperty("file.separator") + fileName);
		LOGGER.info(file.getCanonicalPath());
		LOGGER.info("File creation operation : " + file.createNewFile());

		try (InputStream input = connection.getInputStream();
				FileOutputStream fileWriter = new FileOutputStream(file);) {
			transporter = new TransferObject(input, fileWriter);
			int count = 0;
			LOGGER.info("Attempting to start writing to file");
			while ((count = transporter.transfer(1024, 0)) != -1) {
				downloaded += count;
				progressBar.setValue(getPogress());
			}
			LOGGER.info("Writing finished");
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Opens a connection to the URL that was entered in the UI interface.
	 * 
	 * @return a {@link URLConnection} to a specific URL address.
	 * @throws MalformedURLException
	 *             if the entered URL is not valid.
	 * @throws IOException
	 *             if there is a problem opening the connection.
	 */
	protected URLConnection openConnection() throws MalformedURLException,
			IOException {
		downloadURL = new URL(url);
		return downloadURL.openConnection();
	}

	/**
	 * Constructor.
	 * 
	 * @param url
	 *            the URL of the resource.
	 * @param saveLocation
	 *            the location in which to download the specified file.
	 * @param progressBar
	 *            the progress bar this task is associated with.
	 */
	public DownloadUITask(String url, String saveLocation,
			JProgressBar progressBar) {
		this.url = url;
		this.saveLocation = saveLocation;
		this.progressBar = progressBar;
	}

	/**
	 * Calculates the progress of the download.
	 * 
	 * @return the progress of the download.
	 */
	public int getPogress() {
		return (int) ((double) downloaded / (double) fileSize * 100);
	}

	/**
	 * Converts a long value of bytes in understandable values.
	 * 
	 * @param bytes
	 *            the number of bytes we want to convert
	 * @return the converted value.
	 */
	public static String humanReadableByteCount(long bytes) {
		int unit = 1024;
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String prefix = ("KMGTPE").charAt(exp - 1) + ("i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), prefix);
	}

	/**
	 * Shows an error message to the user for invalid download address.
	 */
	public void showErrorMessage() {
		JOptionPane.showMessageDialog(null, "Can`t download on this address",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
}
