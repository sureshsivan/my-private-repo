package in.v8delta.template.myWebAppTmpl.core.log;

import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 * Factory Class for Loggers
 * 
 * @author v8-suresh
 *
 */
public class LogFactory {

	private LogFactory() {

	}
	
	/**
	 * Map which hold all of the logger agen instances for re use
	 */
	private static final Map<String, LoggerAgent> loggerAgents = new HashMap<String, LoggerAgent>();
	
	/**
	 * Util method which creates appropriate Logger
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public static LoggerAgent getLogger(LoggerType type, String name){
		
		String loggerKey = type.toString() + AppConstants.STR_HYPHEN + name;
		
		LoggerAgent loggerAgent = loggerAgents.get(loggerKey);
		
		if(loggerAgent == null){
			switch (type) {
			case LOG_4_J_LOGGER:
				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
				break;
			case JDK_LOGGER:
				loggerAgent = new JdkLoggerAgent(java.util.logging.Logger.getLogger(name));
				break;
			case OTHER_LOGGER:
				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
				break;
			default:
				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
				break;
			}
		}
		return loggerAgent;
	}
	
	
	/**
	 * Logger which aware of Request Context - informations such as 
	 *		ip Address, Session ... Data from Request 
	 * 
	 * @param name
	 * @return
	 */
	public static LoggerAgent getRequestContextAwareLogger(String name){
		return null;
	}
	
	/**
	 * 
	 * Adds a key/valus pair to Logging Context print in logger statement
	 * 
	 * @param key
	 * @param value
	 */
	public static void addLoggerMessageKey(String key, String value){
		MDC.put(key, value);
	}
	
	/**
	 * Removes the key from Logging Context
	 * 
	 * @param key
	 */
	public static void removeLoggerMessageKey(String key){
		MDC.remove(key);
	}
	
	
}
