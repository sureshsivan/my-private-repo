package in.v8delta.template.myWebAppTmpl.core.log;

/**
 * 
 * Interface which declares methods for LogFactory.
 * 		Specific LoggerFactories should implement these methods.
 * 
 * @author v8-suresh
 *
 */
public interface LogFactory {

	public LoggerAgent getLogger(String name);
	public LoggerAgent getRequestContextAwareLogger(String name);
	public void addLoggerMessageKey(String key, String value);
	public void removeLoggerMessageKey(String key);
	
}
