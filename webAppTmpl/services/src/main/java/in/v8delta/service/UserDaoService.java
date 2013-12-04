package in.v8delta.service;

import java.util.List;

import in.v8delta.domain.User;

/**
 * 
 * Interface which provides services for USer based Operations such as 
 *     User Login, user info update...
 * 
 * @author v8-suresh
 *
 */
public interface UserDaoService {

	User retrieveUserByAnyIdentity(String identity, String password);
	List<User> retrieveAllUsers();
	List<User> retrieveUsersbyRoleId(String roleId);
	boolean authenticateUserbyAnyIdentity(String identity, String password);
	
	
}
