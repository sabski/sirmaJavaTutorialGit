package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import javax.swing.SwingWorker;

import org.apache.log4j.Logger;

public class DownloadUITask extends SwingWorker<Void, Void> {

	private static Logger log = Logger.getLogger(DownloadAgent.class);
	private final DownloadAgent agent;
	private final String url;
	private final String saveLocation;

	/**
	 * @param agent
	 * @param url
	 * @param saveLocation
	 */
	public DownloadUITask(DownloadAgent agent, String url, String saveLocation) {
		this.agent = agent;
		this.url = url;
		this.saveLocation = saveLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void done() {
		super.done();
	}

	@Override
	protected Void doInBackground() throws Exception {
		log.info("Started background task");
		agent.downloadFile(url, saveLocation);
		
		return null;
	}

}
