package com.example.learning.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		
		lock.lock();
		
		
		lock.unlock();
		
		
	}
}
