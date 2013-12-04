package in.v8delta.mybatis.spi;

import in.v8delta.mybatis.MyBatisDataProvider;
import in.v8delta.processor.ResultProcessor;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;
import in.v8delta.util.MyBatisSqlSessionFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public SqlSessionFactory resolveSessionFactoryFromKey(String sessionFactoryKey){
		SqlSessionFactory factory = null;
		synchronized (sessionFactories) {
			
		}
		return factory;
	}
	
}
