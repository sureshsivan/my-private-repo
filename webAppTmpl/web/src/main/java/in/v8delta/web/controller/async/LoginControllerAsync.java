package in.v8delta.web.controller.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class LoginControllerAsync {
	
	@RequestMapping(value = "loginService", method = RequestMethod.POST)
	public @ResponseBody String doUserLogin(){
		// Check For User Login Here
		// Added Some Comments in master branch
		//	This added from test-2 branch (Originally branched from branch after branch update)
		return "";
	}
	
}
