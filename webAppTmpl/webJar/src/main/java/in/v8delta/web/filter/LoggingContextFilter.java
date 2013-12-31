package in.v8delta.web.filter;

import in.v8delta.template.myWebAppTmpl.core.utils.HttpSessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author v8-suresh
 *
 */
public class LoggingContextFilter extends BaseFilter{

	@Override
	protected boolean processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		HttpSessionUtil.requestPreProcessForLogger(req);
		System.out.println("Logging Context Filter Processed : processRequest");
		return true;
	}

	@Override
	protected boolean processResponse(HttpServletRequest req,
			HttpServletResponse resp) {
		HttpSessionUtil.requestPostProcessForLogger(req);
		System.out.println("Logging Context Filter Processed : processResponse");
		return true;
	}

}
