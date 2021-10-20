package com.example.learning.forkjoin.howto;

import java.util.concurrent.ForkJoinPool;

public class Test {
	
	public static void main(String[] args) {
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of processors" + numberOfProcessors);
		ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
		
	}

}
