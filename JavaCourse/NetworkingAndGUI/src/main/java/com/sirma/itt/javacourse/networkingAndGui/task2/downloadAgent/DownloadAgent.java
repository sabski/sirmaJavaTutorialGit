package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class DownloadAgent {

	private static Logger log = Logger.getLogger(DownloadAgent.class);
	public static final String SAVE_LOCATION = System.getProperty("user.home") + "/Downloads";
	private URLConnection connection;
	private URL downloadURL;

	/**
	 * Downloads a file from a specific location on the web to a local location.The User only needs
	 * to specify the directory.
	 * 
	 * @param url
	 *            the web address of the file.
	 * @param saveLocation
	 *            the directory in which the file will be saved.
	 * @throws IOException 
	 */
	public void downloadFile(String url, String saveLocation) throws IOException {

		downloadURL = new URL(url);
		connection = downloadURL.openConnection();
		log.info("The length of the content : "
				+ humanReadableByteCount(connection.getContentLengthLong()));
		String fileName = FilenameUtils.getBaseName(url) + "." + FilenameUtils.getExtension(url);
		File file = new File(saveLocation + "/" + fileName);
		log.info(file.getCanonicalPath());
		log.info("File creation operation : " + file.createNewFile());

		try (InputStream input = connection.getInputStream();
				FileOutputStream fileWriter = new FileOutputStream(file);) {
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			byte[] data = new byte[1024];
			int count;
			log.info("Attempting to start writing to file");
			while ((count = in.read(data, 0, 1024)) != -1) {
				fileWriter.write(data, 0, count);
			}
			log.info("Writing finished");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

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
