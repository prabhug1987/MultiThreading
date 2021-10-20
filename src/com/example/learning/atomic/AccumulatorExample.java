package com.example.learning.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

public class AccumulatorExample {
	public static void main(String[] args) {
		LongBinaryOperator op = (x,y)-> 2 * x + y;
		LongAccumulator longAccumulator = new LongAccumulator(null, 0);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0,10).forEach(i->executor.submit(()->longAccumulator.accumulate(i)));
		System.out.println(longAccumulator.getThenReset());
	}
}
