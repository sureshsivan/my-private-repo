package in.v8delta.web.util;

import in.v8delta.template.myWebAppTmpl.core.log.LogFactory;
import in.v8delta.web.filter.BaseFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Utility class used for HttpSession utuility functons
 * 
 * @author v8-suresh
 *
 */
public final class HttpSessionUtil{

	
	public static void requestPreProcessForLogger(HttpServletRequest request){
		LogFactory.addLoggerMessageKey(WebConstants.LOG_KEY_SESSION_ID, request.getSession().getId());
		LogFactory.addLoggerMessageKey(WebConstants.LOG_KEY_IP_ADDRESS, request.getLocalAddr());
		
	}
	
	public static void requestPostProcessForLogger(HttpServletRequest request){
		
	}
	
}
