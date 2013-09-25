package in.v8delta.template.myWebAppTmpl.core.crypt;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;
import in.v8delta.template.myWebAppTmpl.core.utils.AppConstants;
import in.v8delta.template.myWebAppTmpl.core.utils.LogUtil;

/**
 * MD5 Encoder Implementation
 * 
 * @author v8-suresh
 *
 */
public class SHA512Encoder extends BaseEncoder{

	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(SHA512Encoder.class);
	
	public SHA512Encoder() {
		super(AppConstants.ENCODING_SHA_512);
	}
	
}
