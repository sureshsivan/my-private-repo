package in.v8delta.web.controller.async;

import in.v8delta.service.UserDaoService;
import in.v8delta.template.myWebAppTmpl.core.concurrent.processor.TaskProcessor;
import in.v8delta.template.myWebAppTmpl.core.concurrent.processor.TaskProcessorImpl;
import in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask;
import in.v8delta.template.myWebAppTmpl.core.mail.EmailEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginControllerAsync {

//	@Autowired
	private UserDaoService userDao;
	
	@Autowired
	private TaskProcessor emailSenderTaskProcessor;
	
	@RequestMapping(value = "loginService", method = RequestMethod.POST)
	public @ResponseBody String doUserLogin(){
		
		
		this.emailSenderTaskProcessor.processTasks();
		
		return "{success: true," +
					"user: {" +
						"'name': 'Suresh'," +
						"'id': 'Suresh.sivanantham@gmail.com'" +
				"}}";
	}

	public UserDaoService getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoService userDao) {
		this.userDao = userDao;
	}

	public TaskProcessor getEmailSenderTaskProcessor() {
		return emailSenderTaskProcessor;
	}

	public void setEmailSenderTaskProcessor(TaskProcessor emailSenderTaskProcessor) {
		this.emailSenderTaskProcessor = emailSenderTaskProcessor;
	}

}
