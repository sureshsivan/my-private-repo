package in.v8delta.domain;

import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;

import java.io.Serializable;

/**
 * 
 * Domain Object of each User
 * 
 * @author v8-suresh
 * 
 */

public class User implements Serializable {

	private static final long serialVersionUID = 8032550450613762604L;

	private Long id;
	private String email;
	private String password;

	private boolean isAdmin;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [email=" + this.email
				+ ", isAdmin=" + this.isAdmin + "]";
	}

}
