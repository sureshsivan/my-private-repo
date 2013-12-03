package in.v8delta.util;

import java.io.IOException;
import java.util.Collection;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

/**
 * 
 * Factory Class which Takes care of creating my-batis sql session factories 
 * 
 * @author v8-suresh
 *
 */
public class MyBatisSqlSessionFactory extends SqlSessionFactoryBean{

	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(MyBatisSqlSessionFactory.class);
	
	public MyBatisSqlSessionFactory() {
		super();
	}

	/**
	 * Overridden method which is modified to log the available SQL Statements. 
	 */
	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException,
			IllegalAccessException, InstantiationException {
		SqlSessionFactory sqlSessionFactory = super.buildSqlSessionFactory();
		if(LOGGER.isDebugEnabled()){
			Collection<MappedStatement> allStatements = sqlSessionFactory.getConfiguration().getMappedStatements();
			for(MappedStatement statement : allStatements){
				LOGGER.debug("QUERY ID : " + statement.getId());
				LOGGER.debug("QUERY : " + statement.getSqlSource());
			}			
		}
		
		return sqlSessionFactory;
	}
	
}
