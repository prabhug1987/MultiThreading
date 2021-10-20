package com.example.learning.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ActionExample {
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(64);

		forkJoinPool.invoke(myRecursiveAction);
	}

}
