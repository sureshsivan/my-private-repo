package in.v8delta.web.controller.async;

import in.v8delta.service.UserDaoService;
import in.v8delta.service.spi.UserDaoServiceImpl;

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
		
		return "{success: true," +
					"user: {" +
						"'name': 'Suresh'," +
						"'id': 'Suresh.sivanantham@gmail.com'" +
				"}}";
	}
	
}
