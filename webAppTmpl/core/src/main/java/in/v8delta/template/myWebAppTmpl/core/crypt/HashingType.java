package in.v8delta.template.myWebAppTmpl.core.crypt;

import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;

/**
 * 
 * Enumeration for Various Encoding Implementations used in Application
 * 
 * @author v8-suresh
 *
 */
public enum HashingType {
	
	MD5(AppConstants.ENCODING_MD5),
	SHA_256(AppConstants.ENCODING_SHA_256),
	SHA_384(AppConstants.ENCODING_SHA_384),
	SHA_512(AppConstants.ENCODING_SHA_512);
	
	private String hashType;
	
	HashingType(String hashType){
		this.hashType = hashType;
	}
	
	public String getHashType(){
		return this.hashType;
	}
	
}
