package in.v8delta.template.myWebAppTmpl.core.log;

/**
 * 
 * LoggerAgent Interface. All independent Loggers will implement this interface
 * 
 * @author v8-suresh
 * 
 */
public interface LoggerAgent {

	public boolean isTraceEnabled();
	public boolean isDebugEnabled();
	public boolean isInfoEnabled();
	public boolean isWarnEnabled();
	public boolean isErrorEnabled();
	public boolean isFatalEnabled();

	public String getLevel();
	public void setLevel(String level);

	public void trace(Object message);
	public void trace(Object message, Throwable t);
	public void debug(Object message);
	public void debug(Object message, Throwable t);
	public void info(Object message);
	public void info(Object message, Throwable t);
	public void warn(Object message);
	public void warn(Object message, Throwable t);
	public void error(Object message);
	public void error(Object message, Throwable t);
	public void fatal(Object message);
	public void fatal(Object message, Throwable t);

}
