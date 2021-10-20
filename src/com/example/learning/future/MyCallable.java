package com.example.learning.future;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private long waitTime;

	public MyCallable(int timeInMilliseconds) {
		this.waitTime = timeInMilliseconds;

	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(waitTime);
		return Thread.currentThread().getName();
	}

}
