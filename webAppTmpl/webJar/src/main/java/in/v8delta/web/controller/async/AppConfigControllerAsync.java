package in.v8delta.web.controller.async;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;
import in.v8delta.template.myWebAppTmpl.core.utils.PropertyUtil;
import in.v8delta.web.util.WebConstants;

import java.util.List;

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
	public List<String> getAllResources(HttpServletRequest request){
		LOGGER.debug("Start of getAllResources");
		List<String> out = PropertyUtil.getPropertiesStrAsList(System.getProperty(WebConstants.PROP_KEY_RB_FILE), 
							RequestContextUtils.getLocale(request));
		LOGGER.debug("End of getAllResources : " + out.toString());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	
	@RequestMapping("params")
	@ResponseBody
	public List<String> getApplicationParameters(HttpServletRequest request){
		LOGGER.debug("Start of getApplicationParameters");
		List<String> out = PropertyUtil.getPropertiesStrAsList(System.getProperty(WebConstants.PROP_KEY_APP_PARAM_FILE));
		LOGGER.debug("End of getApplicationParameters : " + out.toString());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	
}
