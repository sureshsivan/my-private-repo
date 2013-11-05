package in.v8delta.domain;

import java.io.Serializable;

/**
 * Domain Model for the bean Project
 * 
 * @author v8-suresh
 *
 */
public class Project implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6858625823262184564L;


	private Long id;
	private String projectName;
	private User projectOwner;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectOwner
	 */
	public User getProjectOwner() {
		return projectOwner;
	}
	/**
	 * @param projectOwner the projectOwner to set
	 */
	public void setProjectOwner(User projectOwner) {
		this.projectOwner = projectOwner;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + this.id
				+ ", projectName=" + this.projectName 
				+ ", projectOwner=" + this.projectOwner + "]";
	}
}
