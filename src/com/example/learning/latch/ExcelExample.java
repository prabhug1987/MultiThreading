package com.example.learning.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcelExample {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(40);
		
		// Thread execution counter of the task, the initial size is the size of the data set to be filled
		        CountDownLatch latch = new CountDownLatch(results.size());
		        for(int i=0; i< results.size(); i++) {
		          //ExcelResultVo excelResultVo = results.get(i);
//		          RowObj rowObj = groups.get(i);
		          es.submit(new Runnable() {
		            @Override
		            public void run() {
		              //PoiWrite.writeData(excelResultVo, wb, sheet, patriarch, styleContent);
		                             latch.countDown();//once each task is done, countDown once
		            }
		          });
		 
		        }
		                 latch.await();//block until the counter has a value of 0, then let the main thread execute
		                 es.shutdown();//Close the thread pool
	}
	
	/*public void insertRow(RowRecord row) {
		// Integer integer = Integer.valueOf(row.getRowNumber());
		_rowRecords.put(Integer.valueOf(row.getRowNumber()), row);
		// Clear the cached values
		_rowRecordValues = null; 
		if ((row.getRowNumber() < _firstrow) || (_firstrow == -1)) {
			_firstrow = row.getRowNumber();
		}
		if ((row.getRowNumber() > _lastrow) || (_lastrow == -1)) {
			_lastrow = row.getRowNumber();
		}
	}*/
}
