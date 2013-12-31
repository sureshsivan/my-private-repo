package in.v8delta.template.myWebAppTmpl.core.concurrent.task;

import java.util.Map;


/**
 * Interface Which is responsible for handling thread based tasks
 * 
 * @author sivasu08
 *
 */
public interface AsyncCapableTask extends Runnable{
	
	public boolean isAsync();
	public void setAsync(boolean async);

	public boolean isEnabled();
	public void setEnabled(boolean enabled);
	
	public void executeTask() throws Exception;
	
	public void preProcessTask();
	public void postProcessTaskSuccess();
	public void postProcessTaskError(Throwable t);
	
}
