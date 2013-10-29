package in.v8delta.web.controller.async;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.KeyValPair;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * This controller is responsible for responding with various Application Configuration items.
 * 	such as, 
 * 		Application Parameters Initialization
 * 		Loading Resource Bundles
 * 		etc... 
 * 
 * @author v8-suresh
 *
 */
@Controller
@RequestMapping("appConfig")
public class AppConfigControllerAsync {

	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(AppConfigControllerAsync.class);
	
	@RequestMapping("resources")
	@ResponseBody
	public List<KeyValPair> getAllResources(HttpServletRequest request){
		LOGGER.debug("Start of getAllResources");
		
		Locale locale = RequestContextUtils.getLocale(request);
		List<KeyValPair> out = new ArrayList<KeyValPair>();

		ResourceBundle rb = ResourceBundle.getBundle(System.getProperty("app.rbFilePath"), locale);
		Enumeration<String> e = rb.getKeys();
		String key = null;
		while(e.hasMoreElements()){
			key = e.nextElement();
			out.add(new KeyValPair(key, rb.getString(key)));
		}
		LOGGER.debug("End of getAllResources : " + out.toString());
		return out;
	}
	
	@RequestMapping("params")
	public List<String> getApplicationParameters(){
		LOGGER.debug("Start of getAllResources");
		
		List<String> out = new ArrayList<String>();
		out.add("one=11111111111");
		out.add("two=222222222");
		out.add("two.three=222222222.3333333333");
		
		LOGGER.debug("End of getAllResources" + out.toString());
		return out;
	}
	
}
