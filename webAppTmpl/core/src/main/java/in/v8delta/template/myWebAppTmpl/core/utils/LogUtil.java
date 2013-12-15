package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.log.LogFactory;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerType;
import in.v8delta.template.myWebAppTmpl.core.log.spi.Log4JLogFactory;

/**
 * 
 * Logger Util class specifically used for Logging Utils
 * 
 * @author v8-suresh
 *
 */
@SuppressWarnings({"unused", "rawtypes"})
public final class LogUtil {

	/**
	 * String Constants for various logging levels available in application
	 */
	public static final String LOG_LVL_TRACE = "info";
	public static final String LOG_LVL_DEBUG = "debug";
	public static final String LOG_LVL_INFO = "info";
	public static final String LOG_LVL_WARN = "warn";
	public static final String LOG_LVL_ERROR = "error";
	public static final String LOG_LVL_FATAL = "fatal";
	
	public static final String REQ_CTX_AWARE_LOGGER_THREAD_KEY = "reqCtxAwareLogger";
	
	public static final String SESSION_ID_LOGGING_CONTEXT_KEY = "sessionId";
	public static final String IP_ADDRESS_LOGGING_CONTEXT_KEY = "ipAddress";
	public static final String USER_ID_LOGGING_CONTEXT_KEY = "userId";
	
	private static final LogUtil INSTANCE = new LogUtil();

	// TODO - A better way to inject this from spring
	private LogFactory logFactory = new Log4JLogFactory();
	
	private LogUtil() {
		
	}
	
	public static LogUtil getInstance() {
		return INSTANCE;
	}
	
	/**
	 * @return the logFactory
	 */
	public LogFactory getLogFactory() {
		return logFactory;
	}

	/**
	 * @param logFactory the logFactory to set
	 */
	public void setLogFactory(LogFactory logFactory) {
		this.logFactory = logFactory;
	}

	
	/**
	 * Single Gateway method get the Logger Agent for the Application
	 * 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getAppLogger(String name){
		//	means its request context aware thread(Generated from servlet)
//		if(ThreadContextVars.get(REQ_CTX_AWARE_LOGGER_THREAD_KEY) != null){
//			return getInstance().getLogFactory().getRequestContextAwareLogger(name);	
//		} else {
//			return getInstance().getLogFactory().getLogger(name);
//		}
		return getInstance().getLogFactory().getLogger(name);
	}

	/**
	 * Single Gateway method get the Logger Agent for the Application
	 * 
	 * @param cls
	 * @return
	 */
	public static LoggerAgent getAppLogger(final Class cls){
		return getAppLogger(cls.getName());
	}


}

