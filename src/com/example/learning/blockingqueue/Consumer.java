package com.example.learning.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	protected BlockingQueue queue = null;
	
	public Consumer(BlockingQueue blockingQueue) {
		this.queue = blockingQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
