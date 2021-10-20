package com.example.learning.lock;

public class Consumer extends Thread {

	ProducerConsumerImpl pc;

	public Consumer(ProducerConsumerImpl sharedObject) {
		super("Consumer");
		this.pc = sharedObject;
	}

	@Override
	public void run() {
		try {
			pc.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
