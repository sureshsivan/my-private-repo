package in.v8delta.template.myWebAppTmpl.core.spring;

import in.v8delta.template.myWebAppTmpl.core.utils.PropertyUtil;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * This class is governed by spring and used to read properties from a file and
 * set it to system properties. Useful whem required to access a property from
 * system property table
 * 
 * @author v8-suresh
 * 
 */
@SuppressWarnings("rawtypes")
public class SystemPropertyInitializer implements InitializingBean {

	private String location;

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * This will get executed after the class properties are injected by Spring.
	 * (In current case its only location property). 
	 */
	public void afterPropertiesSet() throws Exception {

		Properties props = PropertyUtil.loadProperties(this.location);
		Enumeration names = props.propertyNames();

		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String val = props.getProperty(name);

			System.setProperty(name, val);
		}

	}

}
