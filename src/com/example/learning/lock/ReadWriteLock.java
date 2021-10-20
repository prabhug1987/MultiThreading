package com.example.learning.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReadWriteLock {
	private Map<Thread, Integer> readingThreads = new ConcurrentHashMap<Thread, Integer>();
	private Thread callingThread;
	private int writeAccesses = 0;
	private int writeRequests = 0;
	private Thread writingThread = null;
	private int readers = 0;

	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		Thread callingThread = Thread.currentThread();
		while (!canGrantWriteAccess(callingThread)) {
			wait();
		}
		writeRequests--;
		writeAccesses++;
		writingThread = callingThread;
	}

	public synchronized void unlockWrite() throws InterruptedException {
		writeAccesses--;
		if (writeAccesses == 0) {
			writingThread = null;
		}
		notifyAll();
	}

	private boolean canGrantWriteAccess(Thread callingThread) {
		if (isOnlyReader(callingThread))
			return true;
		if (hasReaders())
			return false;
		if (writingThread == null)
			return true;
		if (writingThread != callingThread)
			return false;
		return true;
	}

	private boolean hasReaders() {
		return readingThreads.size() > 0;
	}

	private boolean isOnlyReader(Thread thread) {
		return readers == 1 && readingThreads.get(callingThread) != null;
	}

}