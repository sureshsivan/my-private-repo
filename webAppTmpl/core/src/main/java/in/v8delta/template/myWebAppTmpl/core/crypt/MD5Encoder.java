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
public class MD5Encoder extends BaseEncoder{

	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(MD5Encoder.class);
	
	public MD5Encoder() {
		super(AppConstants.ENCODING_MD5);
	}
	
}
