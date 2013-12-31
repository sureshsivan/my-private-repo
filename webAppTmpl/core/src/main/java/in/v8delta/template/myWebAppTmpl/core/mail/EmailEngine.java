package in.v8delta.template.myWebAppTmpl.core.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import in.v8delta.template.myWebAppTmpl.core.concurrent.task.AsyncCapableTask;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

import java.util.Locale;
import java.util.Map;

import org.springframework.cglib.core.Local;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 * 
 * Class which is responsible for sending e mails
 * 
 * @author v8-suresh
 *
 */
public class EmailEngine implements AsyncCapableTask{

	private final static LoggerAgent LOGGER = LogUtil.getAppLogger(EmailEngine.class);

	private boolean async;
	private boolean enabled;
	private Map<String, Object> emailProps;
	private String mailSubjectTemplateName;
	private String mailBodyTemplateName;
	
	private JavaMailSender javaMailSender;
	private Configuration freemarkerConfiguration;
	
	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Map<String, Object> getEmailProps() {
		return emailProps;
	}

	public void setEmailProps(Map<String, Object> emailProps) {
		this.emailProps = emailProps;
	}

	public String getMailSubjectTemplateName() {
		return mailSubjectTemplateName;
	}

	public void setMailSubjectTemplateName(String mailSubjectTemplateName) {
		this.mailSubjectTemplateName = mailSubjectTemplateName;
	}

	public String getMailBodyTemplateName() {
		return mailBodyTemplateName;
	}

	public void setMailBodyTemplateName(String mailBodyTemplateName) {
		this.mailBodyTemplateName = mailBodyTemplateName;
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public Configuration getFreemarkerConfiguration() {
		return freemarkerConfiguration;
	}

	public void setFreemarkerConfiguration(Configuration freemarkerConfiguration) {
		this.freemarkerConfiguration = freemarkerConfiguration;
	}

	public void run() {
		preProcessTask();
		Throwable taskError = null;
		try {
			executeTask();
		} catch (Throwable t) {
			taskError = t;
		}
		if(taskError == null){
			postProcessTaskSuccess();
		} else {
			postProcessTaskError(taskError);
		}

	}

	public void executeTask() throws Exception {
		
		Locale l = Locale.getDefault();
		
		Template subjectTemplate = getFreemarkerConfiguration().getTemplate(getMailSubjectTemplateName(), l, AppConstants.CHARSET_UTF_8); 
		Template bodyTemplate = getFreemarkerConfiguration().getTemplate(getMailBodyTemplateName(), l, AppConstants.CHARSET_UTF_8);
		
		String mailSubject = FreeMarkerTemplateUtils.processTemplateIntoString(subjectTemplate, getEmailProps());
		String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(bodyTemplate, getEmailProps());
		
		System.out.println("SUBJECT IS : " + mailSubject);
		System.out.println("BODY IS : " + mailBody);
		
		System.out.println("Sending Mail... and waiting for 6 seconds : " + isAsync());
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void preProcessTask() {
		System.out.println("Pre process : " + isAsync());
	}

	public void postProcessTaskSuccess() {
		System.out.println("Post Processs success : " + isAsync());
	}

	public void postProcessTaskError(Throwable t) {
		t.printStackTrace();
		System.out.println("Post Process Failure : " + isAsync());
	}
	
	@Override
	public String toString() {
		return "Email Engine Task";
	}
	
}
