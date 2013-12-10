package in.v8delta.service.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;

import in.v8delta.domain.User;
import in.v8delta.service.UserDaoService;

/**
 * 
 * Service Implementation for User Related DAO methods 
 * 
 * @author v8-suresh
 *
 */
public class UserDaoServiceImpl implements UserDaoService{

	private SessionFactory sessionFactory = null;
	
			
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User retrieveUserByAnyIdentity(String identity, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> retrieveUsersbyRoleId(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authenticateUserbyAnyIdentity(String identity,
			String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
