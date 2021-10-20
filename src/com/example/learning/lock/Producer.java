package com.example.learning.lock;

public class Producer extends Thread {

	ProducerConsumerImpl pc;

	public Producer(ProducerConsumerImpl sharedObject) {
		super("Producer");
		this.pc = sharedObject;
	}

	@Override
	public void run() {
		try {
			pc.put();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
