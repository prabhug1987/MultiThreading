package com.example.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunnable implements Runnable {

	CyclicBarrier barrier1 = null;
	CyclicBarrier barrier2 = null;
	
	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
		// TODO Auto-generated constructor stub
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
			
			this.barrier1.await();
			
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 2" );
			
			this.barrier2.await();
			System.out.println(Thread.currentThread().getName() + " done");
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
