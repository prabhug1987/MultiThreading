package com.example.barrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		Runnable barrierAction = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Barrier 1 action executed");
			}
		};
		
		Runnable barrierAction2 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Barrier 2 action executed");
			}
		};
		
		CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2, barrierAction);
		CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2, barrierAction2);
		
		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(cyclicBarrier1, cyclicBarrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(cyclicBarrier1, cyclicBarrier2);
		
		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
			
	}

}
