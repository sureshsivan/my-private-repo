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
@SuppressWarnings({"unused", "rawtypes"})
public class LogUtil {

	/**
	 * Util method to get Log4J Logger from String 
	 * @param name
	 * @return
	 */
	private static LoggerAgent getLog4JLogger(String name){
		return LogFactory.getLogger(LoggerType.LOG_4_J_LOGGER, name);
	}
	
	/**
	 * Util method to get Log4J Logger from Class 
	 * @param name
	 * @return
	 */
	private static LoggerAgent getLog4JLogger(final Class cls){
		return getLog4JLogger(cls.getName());
	}
	
	
	/**
	 * Util method to get JDK Logger from String 
	 * @param name
	 * @return
	 */
	private static LoggerAgent getJdkLogger(String name){
		return LogFactory.getLogger(LoggerType.JDK_LOGGER, name);
	}
	
	/**
	 * Util method to get JDK Logger from Class 
	 * @param name
	 * @return
	 */
	private static LoggerAgent getJdkLogger(final Class cls){
		return getJdkLogger(cls.getName());
	}
	
	/**
	 * Single Gateway method get the Logger Agent for the Application
	 * 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getAppLogger(String name){
		return getLog4JLogger(name);
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

