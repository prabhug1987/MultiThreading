package com.example.learning.queues;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueueExample {
	
	public static void main(String[] args) {
		DelayQueue delayQueue = new DelayQueue<>();
		Delayed delayed = new Delayed() {
			
			@Override
			public int compareTo(Delayed o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getDelay(TimeUnit unit) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		delayQueue.put(delayed);
		
		Delayed element2 = delayQueue.take();
	}

}
