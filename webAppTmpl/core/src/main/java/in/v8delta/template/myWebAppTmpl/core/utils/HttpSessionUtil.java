package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.web.util.WebConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Utility methods which are related to HttpSessions, HttpServletRequest, HttpServletResponse
 * 
 * @author v8-suresh
 *
 */
public class HttpSessionUtil {

	public static void requestPreProcessForLogger(HttpServletRequest request){
		HttpSession session = request.getSession();
		LogUtil.getInstance().getLogFactory().addLoggerMessageKey(WebConstants.LOG_KEY_SESSION_ID, request.getSession().getId());
		LogUtil.getInstance().getLogFactory().addLoggerMessageKey(WebConstants.LOG_KEY_IP_ADDRESS, request.getLocalAddr());
		LoggerAgent reqContextAwareLogger = LogUtil.getAppLogger(WebConstants.LOGGER_SESSION_LOGGER_PREFIX + session.getId());
		ThreadContextVars.put(WebConstants.LOGGER_SESSION_LOGGER, reqContextAwareLogger);
		
	}
	
	public static void requestPostProcessForLogger(HttpServletRequest request){
		ThreadContextVars.remove(WebConstants.LOGGER_SESSION_LOGGER);
	}	
	
}
