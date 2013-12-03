package in.v8delta.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Domain Object of each User
 * 
 * @author v8-suresh
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 8032550450613762604L;

	private Long userId;
	private String userName;
	private String userMail;
	private String password;

	private String userFirstName;
	private String userLastName;
	
	private List<Role> userRoles;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userMail
	 */
	public String getUserMail() {
		return userMail;
	}
	/**
	 * @param userMail the userMail to set
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}
	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}
	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	/**
	 * @return the userRoles
	 */
	public List<Role> getUserRoles() {
		return userRoles;
	}
	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}
