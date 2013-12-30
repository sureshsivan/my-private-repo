package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.concurrent.processor.TaskProcessor;
import in.v8delta.template.myWebAppTmpl.core.concurrent.processor.TaskProcessorImpl;
import in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask;
import in.v8delta.template.myWebAppTmpl.core.concurrent.task.EmailEngine;

public class TempMainRunner {

	public static void main(String[] args) throws InterruptedException {
		
		AsyncCapableTask emailAsync = new EmailEngine();
		emailAsync.setAsync(true);
		emailAsync.setEnabled(true);

		AsyncCapableTask emailSync = new EmailEngine();
		emailSync.setAsync(false);
		emailSync.setEnabled(true);
		
		TaskProcessor tp = new TaskProcessorImpl();
		tp.addTask(emailAsync);
		tp.addTask(emailSync);
		tp.addTask(emailAsync);
		
		tp.processTasks();
		
		System.out.println("PROCESSING COMPLETED");
		
//		Thread.sleep(3000000);
//		((ThreadPoolTaskExecutor)tp.getTaskExecutor()).shutdown();
		
//		System.out.println("Thread Terminated");
		
	}
	
}
