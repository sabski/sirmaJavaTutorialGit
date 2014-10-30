package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;


/**
 * @author Simeon Iliev
 */
public class RunDownloadAgent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DownloadAgent agent = new DownloadAgent();
/*		try {
			// agent.downloadFile("http://img2.wikia.nocookie.net/__cb20101012010956/fairytail/images/7/76/Happy_Anime_S2.png",DownloadAgent.SAVE_LOCATION);
			agent.downloadFile(
					"http://www.nakov.com/books/inetjava/Internet-Programming-with-Java-Book-Svetlin-Nakov-v1.1.pdf",
					DownloadAgent.SAVE_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
		 new DownloadAgentGui();
	}
}
