package in.v8delta.template.myWebAppTmpl.core.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Agent for Log4J logger Implementation
 * 
 * @author v8-suresh
 *
 */
public class Log4jLoggerAgent implements LoggerAgent{

	// Log4J logger Instance
	private final Logger logger;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param logger
	 */
	public Log4jLoggerAgent(final Logger logger) {
		this.logger = logger;
	}
	public boolean isTraceEnabled() {
		return this.logger.isTraceEnabled();
	}
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}
	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}
	public boolean isWarnEnabled() {
		return true;
	}
	public boolean isErrorEnabled() {
		return true;
	}
	public boolean isFatalEnabled() {
		return true;
	}
	public String getLevel() {
		return this.logger.getLevel().toString();
	}
	public void setLevel(String level) {
		this.logger.setLevel(Level.toLevel(level));
	}
	public void trace(Object message) {
		this.logger.trace(message);
	}
	public void trace(Object message, Throwable t) {
		this.logger.trace(message, t);
	}
	public void debug(Object message) {
		this.logger.debug(message);
	}
	public void debug(Object message, Throwable t) {
		this.logger.debug(message, t);
	}
	public void info(Object message) {
		this.logger.info(message);
	}
	public void info(Object message, Throwable t) {
		this.logger.info(message, t);
	}
	public void warn(Object message) {
		this.logger.warn(message);
	}
	public void warn(Object message, Throwable t) {
		this.logger.warn(message, t);
	}
	public void error(Object message) {
		this.logger.error(message);
	}
	public void error(Object message, Throwable t) {
		this.logger.error(message, t);
	}
	public void fatal(Object message) {
		this.logger.fatal(message);
	}
	public void fatal(Object message, Throwable t) {
		this.logger.fatal(message, t);
	}
	
}
