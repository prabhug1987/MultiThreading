package com.example.learning.future;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class TestCallable {

	public static void main(String[] args) {
		Callable callable = Executors.callable(new PrivilegedAction<String>() {
			@Override
			public String run() {
				// TODO Auto-generated method stub
				return null;
			}
		});

		Callable callable1 = Executors.callable(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});

		Executors.privilegedCallable(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
}
