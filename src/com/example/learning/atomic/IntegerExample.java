package com.example.learning.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerExample {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(200);
		System.out.println(atomicInteger.get());
		atomicInteger.set(201);
		System.out.println(atomicInteger.get());
	

		int expectedValue = 201;
		int newValue      = 230;
		atomicInteger.compareAndSet(expectedValue, newValue);
		System.out.println(atomicInteger.get());
		
		System.out.println(atomicInteger.getAndAdd(10));
		System.out.println(atomicInteger.addAndGet(10));
		
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.incrementAndGet());
		
		System.out.println(atomicInteger.getAndDecrement());
		System.out.println(atomicInteger.decrementAndGet());
		
		
	}
}
