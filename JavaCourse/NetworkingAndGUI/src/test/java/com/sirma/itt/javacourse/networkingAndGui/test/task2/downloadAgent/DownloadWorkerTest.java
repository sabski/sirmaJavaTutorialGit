package com.sirma.itt.javacourse.networkingAndGui.test.task2.downloadAgent;

import javax.swing.JProgressBar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent.DownloadUITask;

/**
 * @author Simeon Iliev
 */
public class DownloadWorkerTest {

	private DownloadUITask downloadTask;

	@Mock
	private DownloadUITask spyTask;

	/**
	 * Set up before method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		downloadTask = Mockito.mock(DownloadUITask.class);
		downloadTask.setUp(Mockito.mock(String.class), Mockito.mock(String.class),
				Mockito.mock(JProgressBar.class));
		spyTask = Mockito.spy(new DownloadUITask());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.test.task2.downloadAgent.javacourse.networkingAndGui.task2.downloadAgent.DownloadUITask#doInBackground()}
	 * .
	 */
	@Test
	public void testDoInBackground() {
		spyTask.run();
	}

}
