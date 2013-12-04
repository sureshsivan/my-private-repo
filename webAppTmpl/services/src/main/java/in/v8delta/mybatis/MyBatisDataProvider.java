package in.v8delta.mybatis;

import in.v8delta.processor.ResultProcessor;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * Interface for My Batis Session Provider
 * 
 * @author v8-suresh
 *
 */
public interface MyBatisDataProvider {

	public void addSessionFactory(String sessionFactoryKey, SqlSessionFactory sessionFactory);
	public void addResultProcessor(ResultProcessor resultProcessor);
	
	public SqlSessionFactory resolveSessionFactoryFromKey(String sessionFactoryKey);
	public SqlSessionFactory resolveSessionFactoryFromQueryName(String queryName);
	
}
