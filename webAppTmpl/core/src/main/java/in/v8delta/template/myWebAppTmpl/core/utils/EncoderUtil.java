package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.crypt.Encoder;
import in.v8delta.template.myWebAppTmpl.core.crypt.EncoderFactory;
import in.v8delta.template.myWebAppTmpl.core.crypt.HashingType;
import in.v8delta.template.myWebAppTmpl.core.crypt.MD5Encoder;

/**
 * Utility class for Endoder functions
 * 
 * @author v8-suresh
 *
 */
@SuppressWarnings("unused")
public class EncoderUtil {
	
	/**
	 * Returns MD5 Encoder
	 * 
	 * @return
	 */
	private static Encoder getMD5Encoder(){
		return  EncoderFactory.getEncoder(HashingType.MD5);
	}
	
	/**
	 * Returns SHA-256 Encoder
	 * 
	 * @return
	 */
	private static Encoder getSHA256Encoder(){
		return  EncoderFactory.getEncoder(HashingType.SHA_256);
	}
	
	/**
	 * Returns SHA-384 Encoder
	 * 
	 * @return
	 */
	private static Encoder getSHA384Encoder(){
		return  EncoderFactory.getEncoder(HashingType.SHA_384);
	}
	
	/**
	 * Returns SHA-512 Encoder
	 * 
	 * @return
	 */
	private static Encoder getSHA512Encoder(){
		return  EncoderFactory.getEncoder(HashingType.SHA_512);
	}
	
	/**
	 * The Encoder USed in Application
	 * 
	 * @return
	 */
	public static Encoder getAppEncoder(HashingType hashingType){
		switch (hashingType) {
		case MD5:
			return getMD5Encoder();
		case SHA_256:
			return getSHA256Encoder();
		case SHA_384:
			return getSHA384Encoder();
		case SHA_512:
			return getSHA512Encoder();
		default:
			return getSHA512Encoder();
		}
	}
	
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(new String(getAppEncoder(HashingType.SHA_256).encode("admin")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
