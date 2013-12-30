package in.v8delta.template.myWebAppTmpl.core.concurrent.task;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

/**
 * 
 * Class which is responsible for sending e mails
 * 
 * @author v8-suresh
 *
 */
public class EmailEngine implements AsyncCapableTask{

	private final static LoggerAgent LOGGER = LogUtil.getAppLogger(EmailEngine.class);

	private boolean async;
	private boolean enabled;
	
	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public void run() {
		preProcessTask();
		Throwable taskError = null;
		try {
			executeTask();
		} catch (Throwable t) {
			taskError = t;
		}
		if(taskError == null){
			postProcessTaskSuccess();
		} else {
			postProcessTaskError(taskError);
		}

	}

	public void executeTask() {
		System.out.println("Sending Mail... and waiting for 5 seconds : " + isAsync());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void preProcessTask() {
		System.out.println("Pre process : " + isAsync());
	}

	public void postProcessTaskSuccess() {
		System.out.println("Post Processs success : " + isAsync());
	}

	public void postProcessTaskError(Throwable t) {
		System.out.println("Post Process Failure : " + isAsync());
	}
	
	@Override
	public String toString() {
		return "Email Engine Task";
	}
	
}
