package in.v8delta.template.myWebAppTmpl.core.concurrent.processor;

import in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask;

import java.util.LinkedList;
import java.util.List;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * Implementation class to process Async Tasks(using Executor service) and synchronous tasks 
 * 
 * @author v8-suresh
 *
 */
public class TaskProcessorImpl implements TaskProcessor{

	private List<in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask> tasks;
	private TaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

	public TaskProcessorImpl() {
		tasks = new LinkedList<AsyncCapableTask>();
//		((ThreadPoolTaskExecutor)taskExecutor).setCorePoolSize(5);
//		((ThreadPoolTaskExecutor)taskExecutor).setMaxPoolSize(5);
//		((ThreadPoolTaskExecutor)taskExecutor).setQueueCapacity(5);
		((ThreadPoolTaskExecutor)taskExecutor).initialize();
//		((ThreadPoolTaskExecutor)taskExecutor).setDaemon(true);
	}
	
	
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void setTasks(List<AsyncCapableTask> tasks) {
		this.tasks = tasks;
	}

	public List<AsyncCapableTask> getTasks() {
		return this.tasks;
	}

	public void addTask(AsyncCapableTask task) {
		if(tasks == null)	tasks = new LinkedList<AsyncCapableTask>();
		tasks.add(task);
	}

	public void clearTasks() {
		if(tasks != null)	tasks.clear();
	}

	public void processTasks() {
		for(AsyncCapableTask task : tasks){
			if(! task.isEnabled())	continue;
			if(task.isAsync()){
				getTaskExecutor().execute(task);
			} else {
				task.run();
			}
		}
		System.out.println("ACTIVE COUNT : " + ((ThreadPoolTaskExecutor)this.taskExecutor).getActiveCount());
		System.out.println("ALL TASKS PROCESSED");
	}
}
