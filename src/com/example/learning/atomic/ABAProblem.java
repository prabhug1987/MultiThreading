package com.example.learning.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABAProblem {

	public static void main(String[] args) {
		String initialRef   = "initial value referenced";
		int    initialStamp = 0;

		AtomicStampedReference<String> atomicStringReference =
		    new AtomicStampedReference<String>(
		        initialRef, initialStamp
		    );

		int[] stampHolder = new int[1];
		Object ref = atomicStringReference.get(stampHolder);

		System.out.println(stampHolder[0]);
		if(ref == null){
		    //prepare optimistic modification
		}

		//if another thread changes the
		//reference and stamp here,
		//it can be detected

		int[] stampHolder2 = new int[1];
		Object ref2 = atomicStringReference.get(stampHolder);

		if(ref == ref2 && stampHolder[0] == stampHolder2[0]){
		    //no modification since optimistic modification was prepared

		} else {
		    //retry from scratch.
		}
		
		String newRef   = "new value referenced";
		int    newStamp = initialStamp + 1;

		boolean exchanged = atomicStringReference
		    .compareAndSet(initialRef, newRef, initialStamp, newStamp);
		System.out.println("exchanged: " + exchanged);  //true

		exchanged = atomicStringReference
		    .compareAndSet(initialRef, "new string", newStamp, newStamp + 1);
		System.out.println("exchanged: " + exchanged);  //false

		exchanged = atomicStringReference
		    .compareAndSet(newRef, "new string", initialStamp, newStamp + 1);
		System.out.println("exchanged: " + exchanged);  //false

		exchanged = atomicStringReference
		    .compareAndSet(newRef, "new string", newStamp, newStamp + 1);
		System.out.println("exchanged: " + exchanged);  //true
	}
}
