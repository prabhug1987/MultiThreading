package com.example.learning.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
