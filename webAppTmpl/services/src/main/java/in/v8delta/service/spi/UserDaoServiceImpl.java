package in.v8delta.service.spi;

import in.v8delta.domain.User;
import in.v8delta.service.UserDaoService;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		Session s = this.sessionFactory.openSession();
		s.createQuery("from User");
		return null;
	}

	public List<User> retrieveAllUsers() {
		return null;
	}

	public List<User> retrieveUsersbyRoleId(String roleId) {
		return null;
	}

	public boolean authenticateUserbyAnyIdentity(String identity,
			String password) {
		return false;
	}
	
}
