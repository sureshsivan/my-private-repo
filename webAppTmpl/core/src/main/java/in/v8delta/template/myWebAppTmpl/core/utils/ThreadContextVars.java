package in.v8delta.template.myWebAppTmpl.core.utils;

import in.v8delta.template.myWebAppTmpl.core.log.LoggerAgent;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * A Hashmap backed singleton implementation of ThreadLocals - 
 * 		to kepp objects private to current running thread. 
 * 
 * @author v8-suresh
 *
 */
public final class ThreadContextVars {

	private static final LoggerAgent LOGGER = LogUtil.getAppLogger(ThreadContextVars.class);
	
	private static final ThreadContextVars INSTANCE = new ThreadContextVars();
	
	private final ThreadLocal<Map<String, Object>> threadLocalVar = new ThreadLocal<Map<String,Object>>(); 	
	
	private ThreadContextVars() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method to add Objects to thread local context with string index 
	 * 
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value){
		Map<String, Object> threadLocalVarsMap = INSTANCE.threadLocalVar.get();
		if(threadLocalVarsMap == null){
			threadLocalVarsMap = new HashMap<String, Object>();
			INSTANCE.threadLocalVar.set(threadLocalVarsMap);
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("HashMap Initialized and added into ThraedLocal");
			}
		}
		threadLocalVarsMap.put(key, value);
		
	}
	
	public static Object get(String key){
		Map<String, Object> threadLocalVarsMap = INSTANCE.threadLocalVar.get();
		Object value = null;
		if(threadLocalVarsMap != null){
			value = threadLocalVarsMap.get(key);
		}
		return value;
	}
	
	public static Object remove(String key){
		
		return null;
	}

	public static void clear(){
		
	}
	
	public static ThreadContextVars getInstance(){
		return INSTANCE;
	}
	
}
