package in.v8delta.web.filter;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;
import in.v8delta.web.controller.async.AppConfigControllerAsync;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * Base Filter for All the Application Specific Filters
 * 
 * @author v8-suresh
 *
 */
public class BaseFilter implements Filter{

	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(BaseFilter.class);
	
	private boolean isEnabled;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(getLogger().isDebugEnabled()){
			getLogger().debug("");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
	}

	@Override
	public void destroy() {
		if(getLogger().isDebugEnabled()){
			getLogger().debug("");
		}
		
	}
	
	protected LoggerAgent getLogger(){
		return LOGGER;
	}
	
}
