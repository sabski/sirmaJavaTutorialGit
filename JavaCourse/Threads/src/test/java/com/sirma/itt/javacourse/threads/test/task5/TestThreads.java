package com.sirma.itt.javacourse.threads.test.task5;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task5.synchronized_stack.AddingThread;
import com.sirma.itt.javacourse.threads.task5.synchronized_stack.ObjectListSynchonized;
import com.sirma.itt.javacourse.threads.task5.synchronized_stack.RemovingThread;

/**
 * This is a complex test that will include the following classes. {@link AddingThread},
 * {@link RemovingThread}, {@link ObjectListSynchonized}
 * 
 * @author Simeon Iliev
 */
public class TestThreads {

	private Logger log = Logger.getLogger(TestThreads.class);
	private ObjectListSynchonized list;
	private AddingThread addingThread;
	private RemovingThread removingThread;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		list = new ObjectListSynchonized(1);
		addingThread = new AddingThread(list);
		removingThread = new RemovingThread(list);
	}

	/**
	 * Test if the flag is given when the array is full.
	 */
	@Test
	public void testNormalAdd() {
		addingThread.setUpThread("3");
		addingThread.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertFalse(list.isAddFlag());
	}

	/**
	 * Test if a thread is waiting to add.
	 */
	@Test
	public void testWaitingAdd() {
		AddingThread tempThread = new AddingThread(list);
		tempThread.setUpThread(5);
		addingThread.setUpThread(6);
		addingThread.start();
		tempThread.start();

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(tempThread.isAlive());
		tempThread.stop();
	}

	/**
	 * Test Normal removal.
	 */
	@Test
	public void testNormalRemove() {
		addingThread.setUpThread(5);
		addingThread.start();
		removingThread.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertFalse(list.isRemoveFlag());
	}

	/**
	 * Test if a thread is waiting to remove.
	 */
	@Test
	public void testWaitingRemoval() {
		RemovingThread tempThread = new RemovingThread(list);
		tempThread.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(tempThread.isAlive());
		tempThread.stop();
	}
}
