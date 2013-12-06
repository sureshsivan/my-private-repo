package in.v8delta.dataprovider;

import java.util.List;
import java.util.Map;

import in.v8delta.processor.ResultProcessor;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * Interface for My Batis Session Provider
 * 
 * @author v8-suresh
 *
 */
public interface DataProvider {

	public void addSessionFactory(String sessionFactoryKey, SqlSessionFactory sessionFactory);
	public void addResultProcessor(ResultProcessor resultProcessor);
	
	public SqlSessionFactory resolveSessionFactoryFromKey(String sessionFactoryKey);
	public SqlSessionFactory resolveSessionFactoryFromQueryName(String queryName);
	
	public Object lookupByIdentity(String queryName, Map<String, Object> args);
	public List<Object> lookupAll(String queryName);
	
	public Object updateByIdentity(String queryName, Map<String, Object> args);
	public Object deleteByIdentity(String queryName, Map<String, Object> args);
	
}
