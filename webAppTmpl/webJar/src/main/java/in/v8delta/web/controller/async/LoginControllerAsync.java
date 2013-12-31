package in.v8delta.web.controller.async;

import in.v8delta.service.UserDaoService;
import in.v8delta.service.spi.UserDaoServiceImpl;
import in.v8delta.template.myWebAppTmpl.core.concurrent.processor.TaskProcessor;
import in.v8delta.template.myWebAppTmpl.core.concurrent.processor.TaskProcessorImpl;
import in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask;
import in.v8delta.template.myWebAppTmpl.core.concurrent.task.EmailEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginControllerAsync {

	@Autowired
	UserDaoService userDao;
	
	@RequestMapping(value = "loginService", method = RequestMethod.POST)
	public @ResponseBody String doUserLogin(){
		
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
		
		return "{success: true," +
					"user: {" +
						"'name': 'Suresh'," +
						"'id': 'Suresh.sivanantham@gmail.com'" +
				"}}";
	}
	
}
