package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * This is utility class to load properties file. This class is originally available in apache commons JCS(Java Caching System) lib.
 * 
 * @author v8-suresh
 *
 */
public final class PropertyUtil {
	
	private final static LoggerAgent LOGGER   = LogUtil.getAppLogger(PropertyUtil.class);
	
	private static final boolean THROW_ON_LOAD_FAILURE = true;

	private static final boolean LOAD_AS_RESOURCE_BUNDLE = false;

	private static final String SUFFIX = ".properties";

	/**
	 * Looks up a resource named 'name' in the classpath. The resource must map
	 * to a file with .properties extention. The name is assumed to be absolute
	 * and can use either "/" or "." for package segment separation with an
	 * optional leading "/" and optional ".properties" suffix. Thus, the
	 * following names refer to the same resource:
	 * 
	 * <pre>
	 * some.pkg.Resource
	 * some.pkg.Resource.properties
	 * some/pkg/Resource
	 * some/pkg/Resource.properties
	 * /some/pkg/Resource
	 * /some/pkg/Resource.properties
	 * </pre>
	 * 
	 * @param name
	 *            classpath resource name [may not be null]
	 * @param loader
	 *            classloader through which to load the resource [null is
	 *            equivalent to the application loader]
	 * 
	 * @return resource converted to java.util.Properties [may be null if the
	 *         resource was not found and THROW_ON_LOAD_FAILURE is false]
	 * @throws IllegalArgumentException
	 *             if the resource was not found and THROW_ON_LOAD_FAILURE is
	 *             true
	 */
	public static Properties loadProperties(String name, ClassLoader loader) {
		if (name == null) {
			throw new IllegalArgumentException("null input: name");
		}

		if (name.startsWith("/")) {
			name = name.substring(1);
		}

		if (name.endsWith(SUFFIX)) {
			name = name.substring(0, name.length() - SUFFIX.length());
		}

		Properties result = null;
		InputStream in = null;
		try {
			if (loader == null) {
				loader = ClassLoader.getSystemClassLoader();
			}

			if (LOAD_AS_RESOURCE_BUNDLE) {
				name = name.replace('/', '.');
				// Throws MissingResourceException on lookup failures:
				final ResourceBundle rb = ResourceBundle.getBundle(name,
						Locale.getDefault(), loader);

				result = new Properties();
				for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
					final String key = (String) keys.nextElement();
					final String value = rb.getString(key);

					result.put(key, value);
				}
			} else {
				name = name.replace('.', '/');

				if (!name.endsWith(SUFFIX)) {
					name = name.concat(SUFFIX);
				}

				// Returns null on lookup failures:
				in = loader.getResourceAsStream(name);
				if (in != null) {
					result = new Properties();
					result.load(in); // Can throw IOException
				}
			}
		} catch (Exception e) {
			result = null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable ignore) {

				}
			}
		}

		if (THROW_ON_LOAD_FAILURE && (result == null)) {
			throw new IllegalArgumentException("could not load ["
					+ name
					+ "]"
					+ " as "
					+ (LOAD_AS_RESOURCE_BUNDLE ? "a resource bundle"
							: "a classloader resource"));
		}

		return result;
	}

	/**
	 * A convenience overload of {@link #loadProperties(String, ClassLoader)}
	 * that uses the current thread's context classloader.
	 */
	public static Properties loadProperties(final String name) {
		return loadProperties(name, Thread.currentThread()
				.getContextClassLoader());
	}
	
	
	/**
	 * Utility method which reads the property file and returs each line as List of String
	 *
	 * @param bundle - bundle name to be used
	 * @param locale - locale to used for bundle search
	 * @return
	 */
	public static List<String> getPropertiesStrAsList(String bundle, Locale locale){
		LOGGER.debug("Start of getPropertiesStrAsList : [bundle:" + bundle + AppConstants.STR_SQUARE_BRACE_RIGHT + 
														AppConstants.STR_COMMA + 
														"[locale:" + (locale == null ? AppConstants.STR_NULL : locale.toString()) + AppConstants.STR_SQUARE_BRACE_RIGHT);

		ResourceBundle rb = null;
		if(locale == null){
			rb = ResourceBundle.getBundle(bundle);
		} else {
			rb = ResourceBundle.getBundle(bundle, locale);
		}
		List<String> out = new ArrayList<String>();
		Enumeration<String> e = rb.getKeys();
		String key = null;
		while(e.hasMoreElements()){
			key = e.nextElement();
			out.add(key + AppConstants.STR_EQUAL + rb.getString(key));
		}
		LOGGER.debug("End of getPropertiesStrAsList : " + out.toString());
		return out;
	}
	
	/**
	 * Utility method which reads the property file and returs each line as List of String
	 * 
	 * @param bundle - bundle name to be used
	 * @return
	 */
	public static List<String> getPropertiesStrAsList(String bundle){
		LOGGER.debug("Start of getPropertiesStrAsList Without Locale Param :");
		return getPropertiesStrAsList(bundle, null);
	}
	
}