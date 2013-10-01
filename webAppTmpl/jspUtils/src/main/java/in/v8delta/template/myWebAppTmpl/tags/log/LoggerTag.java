package in.v8delta.template.myWebAppTmpl.tags.log;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 
 * Custom tag class for writing logs from within a jsp file.
 * 
 * <pre>
 * Usage : 
 * -------
 * 
 * 
 * 
 * </pre>
 * 
 * @author v8-suresh
 *
 */
@SuppressWarnings("serial")
public class LoggerTag extends BodyTagSupport{

	private final static LoggerAgent LOGGER = LogUtil.getAppLogger(LoggerTag.class);
	
	private String level;
	private String context;
	
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}


	@Override
	public int doEndTag() throws JspException {
		if(this.level == null){
			LOGGER.error("Attribute level not defined for tag");
		}
		if(this.context == null){
			LOGGER.error("Attribute context not defined for tag");
		}
		try {
			BodyContent body = getBodyContent();
			if(body == null){
				return(SKIP_BODY);
			}
			
			LoggerAgent loggerAgent = LogUtil.getAppLogger(this.context);
			if(this.level.equalsIgnoreCase(LogUtil.LOG_LVL_TRACE)){
				loggerAgent.trace(body.getString());
			} else if(this.level.equalsIgnoreCase(LogUtil.LOG_LVL_DEBUG)){
				loggerAgent.debug(body.getString());
			} else if(this.level.equalsIgnoreCase(LogUtil.LOG_LVL_INFO)){
				loggerAgent.info(body.getString());
			} else if(this.level.equalsIgnoreCase(LogUtil.LOG_LVL_WARN)){
				loggerAgent.warn(body.getString());
			} else if(this.level.equalsIgnoreCase(LogUtil.LOG_LVL_ERROR)){
				loggerAgent.error(body.getString());
			} else if(this.level.equalsIgnoreCase(LogUtil.LOG_LVL_FATAL)){
				loggerAgent.fatal(body.getString());
			}else {
				loggerAgent.info(body.getString());
			}
		} catch (Exception e) {
			LOGGER.error("Ecxeption thrown when printing log from JSP", e);
		} 
		
		return super.doEndTag();
	}
	
}
