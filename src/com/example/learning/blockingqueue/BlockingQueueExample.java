package com.example.learning.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue queue = new ArrayBlockingQueue(1024);
		
		try {
			Producer producer = new Producer(queue);
			Consumer consumer = new Consumer(queue);

			new Thread(producer).start();
			new Thread(consumer).start();

			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
