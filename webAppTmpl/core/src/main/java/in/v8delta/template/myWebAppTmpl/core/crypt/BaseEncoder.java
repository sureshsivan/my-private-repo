package in.v8delta.template.myWebAppTmpl.core.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Base Implementation for the All the various type of encoders
 * 
 * @author v8-suresh
 *
 */
public class BaseEncoder implements Encoder{

	private final static Logger LOGGER = Logger.getLogger(BaseEncoder.class.getName());
	
	/**
	 * Algorithm String to use for encoding
	 */
	private String encodeAlgorithm = null;
	
	protected BaseEncoder(String encodeAlgorithm) {
		super();
		this.encodeAlgorithm = encodeAlgorithm;
	}

	/**
	 * @return the encodeAlgorithm
	 */
	public String getEncodeAlgorithm() {
		return encodeAlgorithm;
	}

	/**
	 * @param encodeAlgorithm the encodeAlgorithm to set
	 */
	public void setEncodeAlgorithm(String encodeAlgorithm) {
		this.encodeAlgorithm = encodeAlgorithm;
	}

	public byte[] encode(byte[] input) throws Exception {
		return getDigestInstance().digest(input);
	}

	public byte[] encode(String input) throws Exception {
		return getDigestInstance().digest(input.getBytes());
	}
	
	protected MessageDigest getDigestInstance(){
		if((this.encodeAlgorithm == null) || (this.encodeAlgorithm.isEmpty())){
			if(LOGGER.isLoggable(Level.SEVERE)){
				LOGGER.severe("encodeAlgorithm property is not set. currently it is null");
			}
			throw new RuntimeException("encodeAlgorithm is null. No algorithm to digest");
		}
		MessageDigest digestor = null;
		try {
			digestor = MessageDigest.getInstance(this.encodeAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			if(LOGGER.isLoggable(Level.SEVERE)){
				LOGGER.severe(e.getLocalizedMessage());
			}
			throw new RuntimeException(e.getLocalizedMessage(), e.getCause());
		}
		return digestor;
	}
	
}
