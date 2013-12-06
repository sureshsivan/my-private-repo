package in.v8delta.mybatis.spi;

import in.v8delta.mybatis.MyBatisDataProvider;
import in.v8delta.processor.ResultProcessor;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;
import in.v8delta.util.MyBatisSqlSessionFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Implementation class of MyBatisSessionProvider
 * 
 * @author v8-suresh
 *
 */
public class MyBatisDataProviderImpl implements MyBatisDataProvider{

	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(MyBatisDataProviderImpl.class);
	
	private Map<String, SqlSessionFactory> sessionFactories;
	private List<ResultProcessor> resultProcessors;
	
	public MyBatisDataProviderImpl() {
		sessionFactories = new HashMap<String, SqlSessionFactory>();
		resultProcessors = new LinkedList<ResultProcessor>();
	}
	
	/**
	 * @return the sessionFactories
	 */
	public Map<String, SqlSessionFactory> getSessionFactories() {
		return sessionFactories;
	}

	/**
	 * @param sessionFactories the sessionFactories to set
	 */
	public void setSessionFactories(Map<String, SqlSessionFactory> sessionFactories) {
		this.sessionFactories = sessionFactories;
	}

	/**
	 * @return the resultProcessors
	 */
	public List<ResultProcessor> getResultProcessors() {
		return resultProcessors;
	}

	/**
	 * @param resultProcessors the resultProcessors to set
	 */
	public void setResultProcessors(List<ResultProcessor> resultProcessors) {
		this.resultProcessors = resultProcessors;
	}


	public void addSessionFactory(String sessionFactoryKey, SqlSessionFactory sessionFactory) {
		if((sessionFactoryKey == null) || (sessionFactory == null)){
			return;
		}
		synchronized (sessionFactories) {
			synchronized (sessionFactory) {
				sessionFactories.put(sessionFactoryKey, sessionFactory);
				if(LOGGER.isDebugEnabled()){
					LOGGER.debug("Session Factory Added : " + sessionFactory);
				}
			}
		}
	}

	public void addResultProcessor(ResultProcessor resultProcessor) {
		if(resultProcessor == null){
			return;
		}
		synchronized (resultProcessors) {
			synchronized (resultProcessor) {
				resultProcessors.add(resultProcessor);
			}
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("Result Processor Added : " + resultProcessor);
			}
		}
	}

	/**
	 * Retrieve session factory based on the key
	 */
	public SqlSessionFactory resolveSessionFactoryFromKey(String sessionFactoryKey){
		if(sessionFactoryKey == null){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("resolveSessionFactoryFromKey : sessionFactoryKey argument cannot be null or empty");
			}
			throw new IllegalArgumentException("resolveSessionFactoryFromKey : sessionFactoryKey argument cannot be null or empty");
		}
		SqlSessionFactory factory = null;
		synchronized (sessionFactories) {
			factory = sessionFactories.get(sessionFactoryKey);
		}
		
		if(factory == null){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("resolveSessionFactoryFromKey : Queryname not associated with any session factory. sessionFactoryKey : " + sessionFactoryKey);
			}
			throw new IllegalArgumentException("resolveSessionFactoryFromKey : Queryname not associated with any session factory. sessionFactoryKey : " + sessionFactoryKey);
		}
		
		return factory;
	}

	/**
	 * Resolves the session Factory based on the query name.
	 * 	
	 * This method loops through all the available Session Factories and then all the available Sql Queries inside each session factory.
	 * When it finds the matching queryName assciated with a session factory, it returns that session factory else it returns IllegalArgumentException.
	 * 
	 */
	public SqlSessionFactory resolveSessionFactoryFromQueryName(String queryName) {
		if((queryName == null) || (queryName.isEmpty())){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("resolveSessionFactoryFromQueryName : queryName argument cannot be null or empty");
			}
			throw new IllegalArgumentException("resolveSessionFactoryFromQueryName : queryName argument cannot be null or empty");
		}
		SqlSessionFactory factory = null;
		synchronized (sessionFactories) {
			for(Map.Entry<String, SqlSessionFactory> entry : sessionFactories.entrySet()){
				if((entry == null) || (entry.getValue() == null))	continue;
				synchronized (entry) {
					Collection<String> associatedQueryNames = entry.getValue().getConfiguration().getMappedStatementNames();
					if (associatedQueryNames != null) {
						for (String name : associatedQueryNames) {
							if (name.trim().equals(queryName.trim())) {
								factory = entry.getValue();
								if (LOGGER.isDebugEnabled()) {
									LOGGER.error("Resolved Session Factory for Query Name : "
											+ queryName
											+ " ## Factory is :"
											+ factory);
								}
								break;
							}
						}
					}
				}
				if(factory != null)	break;
			}
		}
		
		if(factory == null){
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("resolveSessionFactoryFromQueryName : Queryname not associated with any session factory. queryName : " + queryName);
			}
			throw new IllegalArgumentException("resolveSessionFactoryFromQueryName : Queryname not associated with any session factory. queryName : " + queryName);
		}
		
		return factory;
	}
	
	
	
	
}
