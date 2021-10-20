package com.example.learning.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicRefExample {

	public static void main(String[] args) {
		String initialReference = "the initially referenced string";
		AtomicReference atomicReference = new AtomicReference(initialReference);

		System.out.println(atomicReference.get());
		String initialRef = "first text";
		AtomicStampedReference atomicStampedReference = new AtomicStampedReference(initialRef, 0);
		System.out.println(atomicReference.getOpaque());
		System.out.println("reference "+ atomicStampedReference.getReference());
		System.out.println(" get stamp "+atomicStampedReference.getStamp());
				
		int[] ints = new int[10];

		ints[5] = 123;

		AtomicIntegerArray array = new AtomicIntegerArray(ints);
		
		System.out.println(array.get(5));
		AtomicIntegerFieldUpdater<String> atomicIntegerFieldUpdater;

		AtomicLongArray atomicLongArray = new AtomicLongArray(10);
		AtomicLongArray atomicLongArray1 = new AtomicLongArray(new long[] {1l,2l,3l});
		
		AtomicLongFieldUpdater<String> atpAtomicLongFieldUpdater = new AtomicLongFieldUpdater<String>() {
			
			@Override
			public boolean weakCompareAndSet(String obj, long expect, long update) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void set(String obj, long newValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void lazySet(String obj, long newValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public long get(String obj) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean compareAndSet(String obj, long expect, long update) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
	}

}
