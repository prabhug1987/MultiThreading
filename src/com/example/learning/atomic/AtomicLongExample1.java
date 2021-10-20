package com.example.learning.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class AtomicLongExample1 {
	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong();
		Function<Long, Long> myLambda = (input) -> {
			long noOfCalls = atomicLong.incrementAndGet();
			System.out.println("Lambda called "+ noOfCalls + " times.");
			return input * 2;
		};
		
		System.out.println(myLambda.apply(1L));
		System.out.println(myLambda.apply(3L));
		System.out.println(myLambda.apply(5L));
		
	}

}
