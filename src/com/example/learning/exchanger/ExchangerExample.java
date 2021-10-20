package com.example.learning.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {
		//create an exchanger
		Exchanger exchanger = new Exchanger();

		//create an exchanger runnable
		ExchangerRunnable exchangerRunnable1 =
		        new ExchangerRunnable(exchanger, "A");
         System.out.println(exchangerRunnable1.object);
         // create an exchanger runnable 2
		ExchangerRunnable exchangerRunnable2 =
		        new ExchangerRunnable(exchanger, "B");
		 System.out.println(exchangerRunnable2.object);
		
		 // start a thread 
		new Thread(exchangerRunnable1).start();
		
		// start another thread
		new Thread(exchangerRunnable2).start();
	}
}
