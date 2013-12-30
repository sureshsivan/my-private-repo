package in.v8delta.template.myWebAppTmpl.core.concurrent.processor;

import in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask;

import java.util.List;

import org.springframework.core.task.TaskExecutor;

/**
 * 
 * Interface to process Async Tasks(using Executor service) and synchronous tasks 
 * 
 * @author v8-suresh
 *
 */
public interface TaskProcessor {

	public void setTaskExecutor(TaskExecutor taskExecutor);
	public TaskExecutor getTaskExecutor();
	
	public List<AsyncCapableTask> getTasks();
	public void setTasks(List<AsyncCapableTask> tasks);
	
	public void addTask(AsyncCapableTask task);
	public void clearTasks();
	
	public void processTasks();
	
}
