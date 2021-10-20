package com.example.learning.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicExample {
	
	public static void main(String[] args) {
		AtomicBoolean atomicBoolean = new AtomicBoolean(true);
		
		System.out.println(atomicBoolean.get());
		
		atomicBoolean.set(false);
		
		boolean oldValue = atomicBoolean.getAndSet(true);
		
		System.out.println("Old value is "+oldValue);
		
		boolean expectedValue = true;
		boolean newValue      = false;

		boolean wasNewValueSet = atomicBoolean.compareAndSet(
		    expectedValue, newValue);
		
		System.out.println("new value is "+wasNewValueSet);
		
		System.out.println("compare and exchange value ");
		
		atomicBoolean.compareAndExchange(expectedValue, newValue);
		atomicBoolean.compareAndExchangeAcquire(expectedValue, newValue);
		atomicBoolean.compareAndExchangeRelease(expectedValue, newValue);
		atomicBoolean.getAcquire();
		atomicBoolean.getOpaque();
		
		atomicBoolean.weakCompareAndSetPlain(expectedValue, wasNewValueSet);
		//atomicBoolean.weakCompareAndSet(expectedValue, wasNewValueSet);
		atomicBoolean.weakCompareAndSetPlain(expectedValue, wasNewValueSet);
		atomicBoolean.weakCompareAndSetRelease(expectedValue, wasNewValueSet);
		atomicBoolean.weakCompareAndSetVolatile(expectedValue, wasNewValueSet);
		atomicBoolean.weakCompareAndSetAcquire(expectedValue, wasNewValueSet);
		atomicBoolean.getPlain();
		atomicBoolean.get();
	}

}
