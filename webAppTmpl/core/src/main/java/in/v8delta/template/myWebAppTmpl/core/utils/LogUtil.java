package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.log.LogFactory;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerType;

/**
 * 
 * Logger Util class specifically used for Logging Utils
 * 
 * @author v8-suresh
 *
 */
public class LogUtil {

	/**
	 * Util method to get Log4J Logger from String 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getLog4JLoggerLogger(String name){
		return LogFactory.getLogger(LoggerType.LOG_4_J_LOGGER, name);
	}
	
	/**
	 * Util method to get Log4J Logger from Class 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getLog4JLoggerLogger(final Class cls){
		return LogFactory.getLogger(LoggerType.LOG_4_J_LOGGER, cls.getName());
	}
	
	
	/**
	 * Util method to get JDK Logger from String 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getJdkLoggerLogger(String name){
		return LogFactory.getLogger(LoggerType.JDK_LOGGER, name);
	}
	
	/**
	 * Util method to get JDK Logger from Class 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getJdkLoggerLogger(final Class cls){
		return LogFactory.getLogger(LoggerType.JDK_LOGGER, cls.getName());
	}
	
	
}
