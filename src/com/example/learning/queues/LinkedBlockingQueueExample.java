package com.example.learning.queues;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class LinkedBlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<String> unBounded = new LinkedBlockingQueue<String>();
		LinkedBlockingQueue<String> bounded = new LinkedBlockingQueue<String>(1024);
		bounded.put("value");//put value
		String value = bounded.take();
		
		PriorityQueue<String> priorityQueue = new PriorityQueue<>();
		PriorityBlockingQueue<String> priorityQueue2 = new PriorityBlockingQueue<String>();
		SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<Integer>();
		
		System.out.println(synchronousQueue);
		
		BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
		// add the element in a deque
		blockingDeque.add("one");
		blockingDeque.put("two");
		blockingDeque.offer("ten");
		
		// put the element in the last and first
		blockingDeque.putLast("three");
		blockingDeque.putFirst("hello");
		// add the element at the last and first
		blockingDeque.addFirst("1");
		blockingDeque.addLast("2");
		
		blockingDeque.offer("11");
		blockingDeque.offerLast("12");
		List<String> list = new ArrayList<String>();
		list.add("5");
		list.add("6");
		list.add("7");
		blockingDeque.addAll(list);
		
		// print all the values of the deque
		System.out.println("Print values for the deque in ascending order");
		Iterator<String> iterator = blockingDeque.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// print the values from the last
		System.out.println("Print values for the deque in decending order");
		iterator = blockingDeque.descendingIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
				
		//print the first value of deque
		System.out.println(blockingDeque.peek());
		System.out.println(blockingDeque.peekFirst());
		
		//print the first element
		System.out.println("print element and first");
		System.out.println(blockingDeque.element());
		System.out.println(blockingDeque.getFirst());
		System.out.println(blockingDeque.peekFirst());
		System.out.println(blockingDeque.pollFirst());
		System.out.println("using take first "+blockingDeque.takeFirst());
		System.out.println("using take "+blockingDeque.take());
		
		System.out.println("print the last value of deque");
		System.out.println(blockingDeque.getLast());
		System.out.println(blockingDeque.peekLast());
		System.out.println(blockingDeque.pollLast());
		System.out.println(blockingDeque.takeLast());
		//System.out.println("time unit . valueof function "+ blockingDeque.offerLast("20",2000,TimeUnit.valueOf("1")));
		System.out.println("");
		//no enum constant error when you give the value not in enum list
		//System.out.println(blockingDeque.offerLast("20",2000,TimeUnit.valueOf("43200")));
		
		// wait till the the time gets over
		
		System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.DAYS)));
		System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.MILLIS)));
		System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.HOURS)));
		System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.MINUTES)));
		System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.NANOS)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.MONTHS)));
		
		//no time equivalent for half days and weeks
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.HALF_DAYS)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.WEEKS)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.ERAS)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.FOREVER)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.CENTURIES)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.DECADES)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.MICROS)));
		//System.out.println(blockingDeque.pollLast(20000,TimeUnit.of(ChronoUnit.MILLENNIA)));
		
		
		System.out.println("insert the given value in the begining and return a special value");
		System.out.println(blockingDeque.offerFirst(value));
		System.out.println(blockingDeque.offerFirst(value, 0, TimeUnit.DAYS));
		
		// poll first ofter waiting period of time
		System.out.println(blockingDeque.pollFirst(1000,TimeUnit.of(ChronoUnit.HOURS)));
		
		// print the last value using methods in deque
		System.out.println("insert the given value in the end");
		System.out.println(blockingDeque.offerLast(value));
		blockingDeque.addLast("how");
		
		//remove value from the list
		System.out.println("+remove the values from the start of a queue");
		System.out.println(blockingDeque.remove());
		System.out.println(blockingDeque.remove("21"));
		
		System.out.println("+remove the values from the end of a queue");
		System.out.println(blockingDeque.removeFirst());
		System.out.println(blockingDeque.removeFirstOccurrence("21"));
		
		// defining an int predicate
		IntPredicate predicate = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				// TODO Auto-generated method stub
				return 20 == 20;
			}
		};
		
		// predicate with
		predicate = (d)-> d == d; 
		Predicate<String> predicate2 = (d)-> d.equals(d);
		System.out.println(blockingDeque.removeIf((Predicate<? super String>) predicate));
		blockingDeque.removeIf(predicate2);
		//System.out.println(blockingDeque.removeIf(predicate.test(0)));
	
		
		
	}

}
