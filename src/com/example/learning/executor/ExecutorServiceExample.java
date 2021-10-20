/**
 * copy right @ Ganapathylingam corporation use is subject to terms
 */
package com.example.learning.executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/*
 * example for various ways in which you can create thread pool using  Executor service 
 */
public class ExecutorServiceExample {
	public static void main(String[] args) throws InterruptedException {
		int poolSize = 10;
		createCachedThreadPool(poolSize);
		createWorkSteelingPool(poolSize);
		createScheduledThreadPool(poolSize);
		createSingleThreadPool(poolSize);
		createFixedThreadPool(poolSize);
	}

	/*
	 * create a fixed thread pool in java using executors framework
	 */
	private static void createFixedThreadPool(int poolSize) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
		ExecutorService executorService1 = Executors.newSingleThreadExecutor(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				r = () -> {
						System.out.println("ran task");
					};
				return new Thread(r);
			}
		});
		// create a list of callable collection and assign
		Collection<Callable<Integer>> runnableCollection = createCallableCollection();
		// invoke all the callable task
		List<Future<Integer>> futures = executorService.invokeAll(runnableCollection);
		int result = executorService.invokeAny(runnableCollection);// return integer value
		getValueFromFutureList(futures);
	}

	/*
	 * create tasks and add it to list of collection
	 * @return callableCollections
	 */
	private static Collection<Callable<Integer>> createCallableCollection() {
		Collection<Callable<Integer>> callableCollections= new ArrayList<>();
		Callable<Integer> task1 = ()->{System.out.println("task1 done"); return 1;};
		Callable<Integer> task2 = ()->{System.out.println("task2 done"); return 2;};
		Callable<Integer> task3 = ()->{System.out.println("task3 done"); return 3;};
		callableCollections.add(task1);
		callableCollections.add(task2);
		callableCollections.add(task3);
		
		return callableCollections;
	}

	/*
	 * To get the values from the future when the executor framework is running
	 * @param accepts list of future<Integer>
	 */
	private static void getValueFromFutureList(List<Future<Integer>> futures) {
		// TODO Auto-generated method stub
		futures.forEach((future)->{ 
			if(future.isCancelled()) {
				
			}
			if(future.isDone()) {
				
			}
			
			try {
				System.out.println("inside future method ");
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private static void createSingleThreadPool(int poolSize) {
		// uses only one thread for executing the tasks
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		ExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
		ExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				return new Thread(r);
			}
		});
	}

	private static void createScheduledThreadPool(int poolSize) {
		// to create a scheduled thread pool using executor framework by passing pool
		// size
		ExecutorService executorService = Executors.newScheduledThreadPool(poolSize);
		ExecutorService executorService1 = Executors.newScheduledThreadPool(poolSize, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Asynchronous task");
			}
		});
		// shutdown the executor service after all the pool the tasks are executed
		executorService.shutdown();
		executorService.shutdownNow(); // shutdown right away
		if (executorService.isShutdown()) {

		}
	}

	private static void createWorkSteelingPool(int poolSize) {
		// to create a work stealing thread pool
		ExecutorService executorService = Executors.newWorkStealingPool();
		ExecutorService executorService1 = Executors.newWorkStealingPool(10);

		if (executorService.isTerminated()) {

		}
		try {
			executorService.awaitTermination(poolSize, TimeUnit.MILLISECONDS);
			executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					return 10;
				}
			});

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createCachedThreadPool(int poolSize) {
		// to create cached thread pool
		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService1 = Executors.newCachedThreadPool(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				return new Thread(r);
			}
		});
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(" runnable task done");
			}
		});
	}

}
