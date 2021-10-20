package com.example.learning.forkjoin.howto;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// store the full path of the folders this task is going to
	private final String path;
	
	// store the name of the extension
	private final String extension;
	
	
	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}


	@Override
	protected List<String> compute() {
		long startTime = System.nanoTime();
		 
		// TODO Auto-generated method stub
		//List to store the names of the files stored in the folder
		List<String> list = new ArrayList<String>();
		
		//Folder processor tasks to store the substasks that are going to process the subfolders stored in the folder
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		
		//Get the content of the folder
		File file = new File(path);
		
		//get the content of the folder
		File content[] = file.listFiles();
		//For each element in the folder, if there is a subfolder, create a new folder processor object
		// and execute it asynchronously using the fork() method
		
		
		if(content != null) {
			for(int i = 0; i < content.length;i++) {
				if(content[i].isDirectory()) {
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(),extension);
					task.fork();
					tasks.add(task);
				}else {
					if(checkFile(content[i].getName())) {
						list.add(content[i].getAbsolutePath());
					}
				}
			}
		}
		
		if(tasks.size() > 50) {
			System.out.printf("%s : %d tasks ran.\n", file.getAbsolutePath(),tasks.size());
		}
		addResultsFromTasks(list,tasks);
		
		long stopTime = System.nanoTime();
		//System.out.println(stopTime - startTime);
		
		return list;
	}
	
	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
		for(FolderProcessor item:tasks) {
			list.addAll(item.join());
		}
	}
	
	
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}

}
