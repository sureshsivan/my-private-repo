package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.crypt.HashingType;
import in.v8delta.template.myWebAppTmpl.core.log.LoggerType;

/**
 * 
 * All Defaults used throughout the app.
 * 
 * @author v8-suresh
 *
 */
public interface AppDefaults {

	public static final String DIGEST_CHARSET = AppConstants.CHARSET_UTF_8;
	
	public static final HashingType HASH_ENCODING = HashingType.SHA_512;
	
	public static final LoggerType LOGGER_TYPE = LoggerType.LOG_4_J_LOGGER;
	
}
