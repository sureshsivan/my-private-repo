package in.v8delta.template.myWebAppTmpl.core.log.spi;

import in.v8delta.template.myWebAppTmpl.core.log.LogFactory;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 * Factory Class for Loggers
 * 
 * @author v8-suresh
 *
 */
public class Log4JLogFactory implements LogFactory{

	public Log4JLogFactory() {

	}
	
	/**
	 * Map which hold all of the logger agents instances for re use (Cache of Loggers)
	 */
	private static final Map<String, LoggerAgent> loggerAgents = new HashMap<String, LoggerAgent>();
	
	
//	/**
//	 * Util method which creates appropriate Logger
//	 * 
//	 * @param type
//	 * @param name
//	 * @return
//	 */
//	public static LoggerAgent getLogger(LoggerType type, String name){
//		
//		String loggerKey = type.toString() + AppConstants.STR_HYPHEN + name;
//		
//		LoggerAgent loggerAgent = loggerAgents.get(loggerKey);
//		
//		if(loggerAgent == null){
//			switch (type) {
//			case LOG_4_J_LOGGER:
//				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
//				break;
//			case REQ_CTX_AWARE_LOG_4_J_LOGGER:
//				loggerAgent = new RequestContextAwareLog4jLoggerAgent(Logger.getLogger(name));
//				break;
//			case JDK_LOGGER:
//				loggerAgent = new JdkLoggerAgent(java.util.logging.Logger.getLogger(name));
//				break;
//			case OTHER_LOGGER:
//				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
//				break;
//			default:
//				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
//				break;
//			}
//		}
//		return loggerAgent;
//	}

	/**
	 * Util method which creates appropriate Logger
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public LoggerAgent getLogger(String name){
		LoggerAgent loggerAgent ;
		synchronized (loggerAgents) {
			loggerAgent = loggerAgents.get(name);
			if(loggerAgent == null){
				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
				loggerAgents.put(name, loggerAgent);
			}		
		}

				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
		return loggerAgent;
	}
	
	/**
	 * Logger which aware of Request Context - informations such as 
	 *		ip Address, Session ... Data from Request 
	 * 
	 * @param name
	 * @return
	 */
	public LoggerAgent getRequestContextAwareLogger(String name){
		LoggerAgent loggerAgent ;
		synchronized (loggerAgents) {
			loggerAgent = loggerAgents.get(name);
			if(loggerAgent == null){
				loggerAgent = new RequestContextAwareLog4jLoggerAgent(Logger.getLogger(name));
				loggerAgents.put(name, loggerAgent);
			}		
		}

				loggerAgent = new Log4jLoggerAgent(Logger.getLogger(name));
		return loggerAgent;
	}
	
	/**
	 * 
	 * Adds a key/valus pair to Logging Context to print in logger statement
	 * 
	 * @param key
	 * @param value
	 */
	public void addLoggerMessageKey(String key, String value){
		MDC.put(key, value);
	}
	
	/**
	 * Removes the key from Logging Context
	 * 
	 * @param key
	 */
	public void removeLoggerMessageKey(String key){
		MDC.remove(key);
	}

	
	
}
