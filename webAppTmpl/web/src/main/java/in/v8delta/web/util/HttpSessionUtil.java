package in.v8delta.web.util;

import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * Utility class used for HttpSession utuility functons
 * 
 * @author v8-suresh
 *
 */
@Deprecated
public final class HttpSessionUtil{

	
	public static void requestPreProcessForLogger(HttpServletRequest request){
		LogUtil.getInstance().getLogFactory().addLoggerMessageKey(WebConstants.LOG_KEY_SESSION_ID, request.getSession().getId());
		LogUtil.getInstance().getLogFactory().addLoggerMessageKey(WebConstants.LOG_KEY_IP_ADDRESS, request.getLocalAddr());
		
	}
	
	public static void requestPostProcessForLogger(HttpServletRequest request){
		
	}
	
}
