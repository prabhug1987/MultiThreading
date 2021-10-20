package com.example.learning.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class TaskExample {
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		MyRecursiveTask myRecursiveAction = new MyRecursiveTask(128);

		forkJoinPool.invoke(myRecursiveAction);
	}

}
