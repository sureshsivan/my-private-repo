package in.v8delta.template.myWebAppTmpl.core.utils;

/**
 * Simple POJO class to represent key/value pair
 * 
 * @author v8-suresh
 *
 */
public class KeyValPair {

	private String key;
	private String val;
	
	public KeyValPair(String key, String val) {
		super();
		this.key = key;
		this.val = val;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the val
	 */
	public String getVal() {
		return val;
	}
	/**
	 * @param val the val to set
	 */
	public void setVal(String val) {
		this.val = val;
	}
	
	
}
