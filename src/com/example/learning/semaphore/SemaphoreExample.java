/**
 * 
 */
package com.example.learning.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	public static void main(String[] args) throws InterruptedException {
		
		Semaphore semaphore = new Semaphore(1);
		//to aquire a lock on shared region or block
		semaphore.acquire();
		
		// to release a lock on shared object
		semaphore.release();
		
	}

}
