package in.v8delta.web.filter;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;
import in.v8delta.web.controller.async.AppConfigControllerAsync;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sample Filter created for Test..
 * 
 * @author v8-suresh
 *
 */
public class SampleFilter extends BaseFilter{

	
	@Override
	protected boolean processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		System.out.println("Sample Filter processed : processRequest");
		return true;
	}

	@Override
	protected boolean processResponse(HttpServletRequest req,
			HttpServletResponse resp) {
		System.out.println("Sample Filter processed : processResponse");
		return true;
	}

}
