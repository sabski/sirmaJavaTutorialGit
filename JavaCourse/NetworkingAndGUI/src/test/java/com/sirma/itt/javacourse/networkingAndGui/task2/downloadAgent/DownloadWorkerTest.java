package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;

import javax.swing.JProgressBar;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

/**
 * Test class for {@link DownloadUITask}
 * 
 * @author Simeon Iliev
 */
public class DownloadWorkerTest {

	private static Logger log = Logger.getLogger(DownloadWorkerTest.class);
	@Spy
	private DownloadUITask spyTask;

	@Mock
	private JProgressBar progressBar;
	@Mock
	private URLConnection connection;
	private File testFile;

	/**
	 * Set up before method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		progressBar = Mockito.mock(JProgressBar.class);
		connection = Mockito.mock(URLConnection.class);
		testFile = new File(getClass().getResource("/test.png").getFile());
		spyTask = Mockito.spy(new DownloadUITask(testFile.toURI().toURL().toString(),"target", progressBar));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent.javacourse.networkingAndGui.task2.downloadAgent.DownloadUITask#doInBackground()}
	 * .
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	@Test
	public void testDoInBackground() throws MalformedURLException, IOException {
		Mockito.when(spyTask.openConnection()).thenReturn(connection);
		Mockito.when(connection.getContentLengthLong()).thenReturn(154952L);
		Mockito.when(connection.getInputStream()).thenReturn(new FileInputStream(testFile));
		try {
			spyTask.doInBackground();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		Mockito.verify(progressBar, Mockito.atLeastOnce()).setValue(0);
		Mockito.verify(connection, Mockito.atLeastOnce()).getContentLengthLong();
		Mockito.verify(connection, Mockito.atLeastOnce()).getInputStream();

	}

}
