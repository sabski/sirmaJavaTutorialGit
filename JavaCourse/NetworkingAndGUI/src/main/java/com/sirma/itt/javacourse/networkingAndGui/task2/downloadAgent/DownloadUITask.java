package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * 
 * 
 * @author Simeon Iliev
 */
public class DownloadUITask extends SwingWorker<Void, Void> {

	private static Logger log = Logger.getLogger(DownloadUITask.class);
	private String url;
	private String saveLocation;
	private JProgressBar progresBar;
	private long downloaded = 0;
	private long fileSize = 0;
	private URL downloadURL;
	private URLConnection connection;


	@Override
	protected Void doInBackground() throws Exception {
		progresBar.setValue(0);
		downloadURL = new URL(url);
		connection = downloadURL.openConnection();
		log.info("The length of the content : "
				+ humanReadableByteCount(connection.getContentLengthLong()));
		fileSize = connection.getContentLengthLong();
		String fileName = FilenameUtils.getBaseName(url) + "." + FilenameUtils.getExtension(url);
		File file = new File(saveLocation + "/" + fileName);
		log.info(file.getCanonicalPath());
		log.info("File creation operation : " + file.createNewFile());

		try (InputStream input = connection.getInputStream();
				FileOutputStream fileWriter = new FileOutputStream(file);) {
			BufferedInputStream in = new BufferedInputStream(input);
			byte[] data = new byte[1024];
			int count;
			log.info("Attempting to start writing to file");
			while ((count = in.read(data, 0, 1024)) != -1) {
				fileWriter.write(data, 0, count);
				downloaded += count;
				progresBar.setValue(getPogress());
			}
			log.info("Writing finished");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 
	 * @param url
	 * @param saveLocation
	 * @param progresBar
	 */
	public void setUp(String url, String saveLocation, JProgressBar progresBar) {
		this.url = url;
		this.saveLocation = saveLocation;
		this.progresBar = progresBar;
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
		String pre = ("KMGTPE").charAt(exp - 1) + ("i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
