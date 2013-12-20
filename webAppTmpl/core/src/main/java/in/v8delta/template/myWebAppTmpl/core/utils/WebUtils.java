package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.web.util.WebConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * Class which holds the common utility methods for the web module
 * 
 * @author v8-suresh
 *
 */
public class WebUtils {

	/**
	 * Method to check HttpServletRequest is Originated as Ajax Requests
	 * This uses a common mechanism used by many frameworks.
	 * If [X-Requested-With] header is set to "XMLHttpRequest", then its a ajax request
	 * 
	 * @return trus if the HttpServletRequest is Originated as Ajax Requests
	 */
	public static boolean isAjaxRequest(HttpServletRequest request){
		String val = request.getHeader(WebConstants.HTTP_HEADER_KEY_AJAX_REQUEST);
		if ((val == null) || (val.isEmpty()) || (! val.equalsIgnoreCase(WebConstants.HTTP_HEADER_VAL_AJAX_REQUEST)))
			return false;
		return true;
	}
	
}
