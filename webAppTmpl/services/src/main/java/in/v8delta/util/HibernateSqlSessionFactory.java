package in.v8delta.util;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

import java.util.Map.Entry;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

/**
 * 
 * Factory Class which Takes care of creating my-batis sql session factories 
 * 
 * @author v8-suresh
 *
 */
public class HibernateSqlSessionFactory extends LocalSessionFactoryBean{

	private final static LoggerAgent LOGGER  = LogUtil.getAppLogger(HibernateSqlSessionFactory.class);
	
	public HibernateSqlSessionFactory() {
		super();
	}

	
	@Override
	protected SessionFactory buildSessionFactory() throws Exception {
		SessionFactory sessionFactory = super.buildSessionFactory();
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("Session Factory Build with Hibernate Properties");
			for(Entry<Object, Object> entry : this.getHibernateProperties().entrySet()){
				LOGGER.debug(entry.getKey() + AppConstants.STR_COLON + entry.getValue());
			}
		}
		return sessionFactory;
	}
	
	
}
