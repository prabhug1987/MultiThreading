package com.example.learning.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyFutureTask {
	public static void main(String[] args) {
		MyCallable myCallable = new MyCallable(1000);
		MyCallable myCallable1 = new MyCallable(1000);

		FutureTask<String> futureTask = new FutureTask<>(myCallable);
		FutureTask<String> futureTask1 = new FutureTask<>(myCallable1);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(futureTask);
		executor.submit(futureTask1);

		while (true) {
			try {
				if (futureTask.isDone() && futureTask1.isDone()) {
					System.out.println("Done");
					// shut down executor service
					executor.shutdown();
					return;
				}

				if (!futureTask.isDone()) {
					// wait indefinitely for future task to complete
					System.out.println("FutureTask1 output=" + futureTask.get());
				}

				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask1.get(200L, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("FutureTask2 output=" + s);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				// do nothing
			}
		}

	}

}
