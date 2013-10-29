package in.v8delta.web.controller.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class LoginControllerAsync {
	
	@RequestMapping(value = "loginService", method = RequestMethod.POST)
	public @ResponseBody String doUserLogin(){
		return "";
	}
	
}
