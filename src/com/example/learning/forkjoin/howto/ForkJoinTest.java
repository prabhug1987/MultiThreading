package com.example.learning.forkjoin.howto;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinTest {
	
	public static void main(String[] args) {
		//Create ForkJoinPool using default constructor
		ForkJoinPool pool = new ForkJoinPool();
		
		//create thre Folder processor tasks. initialize each one with a different folder path;
		  FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
	      FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
	      FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");
	      
	      //Execute the task
	      pool.execute(system);
	      pool.execute(apps);
	      pool.execute(documents);
	      
	      //write to console information about the status of the pool every second
	      //Utile the three tasks have finished their executeion
		
	      do {
	    	  System.out.printf("******************************************************");
	    	  System.out.printf("Main : Parallelism: %d\n", pool.getParallelism());
	    	  System.out.printf("Main : Active Threads : %d\n", pool.getActiveThreadCount());
	    	  System.out.printf("Main : Task count : %d\n", pool.getQueuedTaskCount());
	    	  System.out.printf("Main : Task count : %d\n", pool.getStealCount());
	    	  System.out.printf("===============================================");
	    	  
	    	  try {
	    		  TimeUnit.SECONDS.sleep(1);
	    	  }catch (Exception e) {
				// TODO: handle exception
	    		  e.printStackTrace();
	    	  }
	      }while((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
	      //shut down ForkJoinPool using the shutdown() method
	      pool.shutdown();
	      //write the numberof results generated by each task to the console
	      
	      List<String> results;
	      results = system.join();
	      System.out.printf("System: %d files found.\n", results.size());
	      
	      results = apps.join();
	      System.out.printf("Apps: %d files found.\n", results.size());
	      results = documents.join();
	      System.out.printf("Documents: %d files found. \n", results.size());
	      
	    	  
	}

}