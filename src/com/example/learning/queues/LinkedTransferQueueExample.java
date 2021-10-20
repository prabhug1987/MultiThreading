package com.example.learning.queues;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueExample {
	
	public static void main(String[] args) {
		LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue<>();
		//add numbers to linked transfer queue
		linkedTransferQueue.add(123456);
		linkedTransferQueue.add(343243);
		linkedTransferQueue.add(341321);
		linkedTransferQueue.add(341671);
		linkedTransferQueue.add(41671);
		
		System.out.println("Linked Transfer queue"+ linkedTransferQueue);
		
		LinkedTransferQueue<Integer> linkedTransferQueue2 = new LinkedTransferQueue<>(linkedTransferQueue);
		
		System.out.println("Linked tranfer queue 2: "+ linkedTransferQueue2);
	}

}
