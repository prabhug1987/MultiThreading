package com.example.learning.exchanger;

import java.util.concurrent.Exchanger;
/*
 * 
 * author Prabhu Ganapathylingam
 * 
 */
public class ExchangerRunnable implements Runnable {
	//define an exchanger
	Exchanger exchanger = null;
	//create on object that you want to share with multiple threads
	Object object = null;

	/**
	 * a constructor that accepts two values 
	 * @param exchanger
	 * @param object
	 */
	public ExchangerRunnable(Exchanger exchanger, Object object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	/*
	 * having own specification of run method from runnable interface
	 * 
	 */
	public void run() {
		try {
			Object previous = this.object;// assign object
			
			// send the shared object to another thread by calling exchange method and assign it to object variable
			this.object = this.exchanger.exchange(this.object); 

			// print the old and new values
			System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}