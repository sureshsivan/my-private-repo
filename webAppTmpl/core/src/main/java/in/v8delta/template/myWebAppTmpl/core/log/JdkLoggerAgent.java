package in.v8delta.template.myWebAppTmpl.core.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Agent for JDK logger Implementation
 * 
 * Level is varying between application logger type and JDK Logger implementations
 * Below is the matching betweek them.
 * 
 * <pre>
 * ---------------------------
 * |   APP     |    JDK      |
 * ---------------------------
 * | ALL       | ALL         |
 * | TRACE     | FINER,FINEST|
 * | DEBUG     | FINE        |
 * | INFO      | INFO,CONFIG |
 * | WARN      | WARNING     |
 * | ERROR     | SEVERE      |
 * | FATAL     | SEVERE      |
 * ---------------------------
 * <pre>
 * 
 * @author v8-suresh
 *
 */
public class JdkLoggerAgent implements LoggerAgent{

	private final Logger logger;
	
	public JdkLoggerAgent(final Logger logger) {
		this.logger = logger;
	}
	
	public boolean isTraceEnabled() {
		return this.logger.isLoggable(Level.FINER) ||
				this.logger.isLoggable(Level.FINEST);
	}

	public boolean isDebugEnabled() {
		return this.logger.isLoggable(Level.FINE); 
	}

	public boolean isInfoEnabled() {
		return this.logger.isLoggable(Level.INFO) ||
				this.logger.isLoggable(Level.CONFIG);
	}

	public boolean isWarnEnabled() {
		return this.logger.isLoggable(Level.WARNING); 
		}

	public boolean isErrorEnabled() {
		return this.logger.isLoggable(Level.SEVERE); 
		}

	public boolean isFatalEnabled() {
		return this.logger.isLoggable(Level.SEVERE); 
		}

	public String getLevel() {
		return this.logger.getLevel().getName();
	}

	public void setLevel(String level) {
		this.logger.setLevel(Level.parse(level));
	}

	public void trace(Object message) {
		this.logger.finer(message.toString());
	}

	public void trace(Object message, Throwable t) {
		this.logger.log(Level.FINER, message.toString(), t);
	}

	public void debug(Object message) {
		this.logger.fine(message.toString());
	}

	public void debug(Object message, Throwable t) {
		this.logger.log(Level.FINE, message.toString(), t);		
	}

	public void info(Object message) {
		this.logger.info(message.toString());		
	}

	public void info(Object message, Throwable t) {
		this.logger.log(Level.INFO, message.toString(), t);		
	}

	public void warn(Object message) {
		this.logger.warning(message.toString());		
	}

	public void warn(Object message, Throwable t) {
		this.logger.log(Level.WARNING, message.toString(), t);		
	}

	public void error(Object message) {
		this.logger.severe(message.toString());		
	}

	public void error(Object message, Throwable t) {
		this.logger.log(Level.SEVERE, message.toString(), t);		
	}

	public void fatal(Object message) {
		this.logger.severe(message.toString());		
	}

	public void fatal(Object message, Throwable t) {
		this.logger.log(Level.SEVERE, message.toString(), t);		
	}
	
}
