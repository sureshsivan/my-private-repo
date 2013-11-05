package in.v8delta.service;

import in.v8delta.domain.User;

/**
 * 
 * Interface which provides services for USer based Operations such as 
 *     User Login, user info update...
 * 
 * @author v8-suresh
 *
 */
public interface UserService {

	public User doUserLogin(String userName, String password);
	
}
